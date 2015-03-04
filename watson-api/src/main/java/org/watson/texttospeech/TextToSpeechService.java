package org.watson.texttospeech;

import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.watson.vcapservices.BluemixServices;
import org.watson.vcapservices.GenericCredentials;
import org.watson.vcapservices.GenericServiceConfig;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import java.io.InputStream;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.commons.io.IOUtils;
import org.watson.vcapservices.BasicAuthenticationFilter;

/**
 * A Question and Answer service facade. If VCAP_SERVICES don't contain your
 * credentials, call init method manually before usage.
 */
@ApplicationScoped
public class TextToSpeechService {

    private JacksonJaxbJsonProvider provider = new JacksonJaxbJsonProvider();
    private ObjectMapper objectMapper = provider.locateMapper(Object.class,
            MediaType.APPLICATION_JSON_TYPE);

    @Inject
    BluemixServices bluemixServices;

    private GenericCredentials credentials;
    private Client client;
    private WebTarget target;

    @PostConstruct
    public void init() {

        List<GenericServiceConfig> qaList = bluemixServices
                .getTextToSpeechConfig();
        if (qaList != null && !qaList.isEmpty()) {
            final GenericCredentials credentials = qaList.get(0).
                    getCredentials();

            client = ClientBuilder.newBuilder()
                    .register(provider)
                    .register(new BasicAuthenticationFilter() {

                        @Override
                        public String getHeader() {
                            return credentials.createAuthorizationHeaderValue();
                        }
                    })
                    .build();

            target = client.target(credentials.getUrl()).path("v1").path(
                    "synthesize");

        } else {
            System.err
                    .println(
                            "Warning, bleumix services couldn't read q&a config");
        }
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
            InputStream in = response.readEntity(InputStream.class);
            try {
                return IOUtils.toByteArray(in);
            } finally {
                in.close();
            }

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
