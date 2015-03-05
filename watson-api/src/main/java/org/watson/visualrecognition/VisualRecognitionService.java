package org.watson.visualrecognition;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.watson.BluemixServices;
import org.watson.GenericCredentials;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.watson.visualrecognition.response.Image;
import org.watson.visualrecognition.response.VisualRecognitionResponse;

/**
 * A Question and Answer service facade. If VCAP_SERVICES don't contain your
 * credentials, call init method manually before usage.
 */
@ApplicationScoped
public class VisualRecognitionService {

    @Inject
    BluemixServices bluemixServices;

    @Inject
    ObjectMapper objectMapper;

    private GenericCredentials credentials;
    private String uri;

    @PostConstruct
    public void init() {

        credentials = bluemixServices
                .getVisualRecognitionConfig().getCredentials();

        uri = credentials.getUrl() + "/v1/tag/recognize";
    }

    public Image recognize(byte[] jpeg) {

        // TODO figure out if there really isn't a way to do this with 
        // standard JAX RS 2.0 Client API ?
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        builder.addBinaryBody("imgFile", jpeg, ContentType.DEFAULT_BINARY,
                "cam.jpg");

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost post = new HttpPost(uri);
        post.addHeader("Authorization", credentials.
                createAuthorizationHeaderValue());
        post.setEntity(builder.build());

        try {
            HttpResponse response = httpclient.execute(post);
            VisualRecognitionResponse r = objectMapper.readValue(
                    EntityUtils.toString(response.getEntity()),
                    VisualRecognitionResponse.class);
            return r.getImages().get(0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
