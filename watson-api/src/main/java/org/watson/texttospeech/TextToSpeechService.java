package org.watson.texttospeech;

import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.watson.BluemixServices;
import org.watson.GenericCredentials;
import java.io.InputStream;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.commons.io.IOUtils;

/**
 * A Question and Answer service facade. If VCAP_SERVICES don't contain your
 * credentials, call init method manually before usage.
 */
@ApplicationScoped
public class TextToSpeechService {

    @Inject
    BluemixServices bluemixServices;

    @Inject
    private Client client;
    private WebTarget target;

    @PostConstruct
    public void init() {

        final GenericCredentials credentials = bluemixServices
                .getTextToSpeechConfig().getCredentials();

        client.register(credentials);

        target = client.target(credentials.getUrl()).path("v1").path(
                "synthesize");
    }

    public List<String> getAvailableVoices() {
        // TODO rest request
        return Collections.singletonList("VoiceEnUsMichael");
    }

    public byte[] textToOgg(String text, String voice) {
        try {

            if (target == null) {
                // For some reason Liberty don't execute init method automatically
                init();
            }

            WebTarget queryParam = target.queryParam("voice", voice).queryParam(
                    "text", text);
            Response response = queryParam.request("audio/ogg; codecs=opus").
                    get();
            try (InputStream in = response.readEntity(InputStream.class)) {
                return IOUtils.toByteArray(in);
            }

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
