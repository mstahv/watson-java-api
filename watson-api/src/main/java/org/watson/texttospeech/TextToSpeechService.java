package org.watson.texttospeech;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.watson.vcapservices.BluemixServices;
import org.watson.vcapservices.GenericCredentials;
import org.watson.vcapservices.GenericServiceConfig;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpEntity;

/**
 * A Question and Answer service facade. If VCAP_SERVICES don't contain your
 * credentials, call init method manually before usage.
 */
@ApplicationScoped
public class TextToSpeechService {

    RestTemplate restTemplate;

    @Inject
    BluemixServices bluemixServices;

    private GenericCredentials credentials;

    @PostConstruct
    public void init() {

        List<GenericServiceConfig> qaList = bluemixServices
                .getTextToSpeechConfig();
        if (qaList != null && !qaList.isEmpty()) {
            credentials = qaList.get(0).getCredentials();
            doInit();
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
        if (restTemplate == null) {
            // For some reason Liberty don't execute init method automatically
            init();
        }
        try {
        	
        	URI uri = new URIBuilder(credentials.getUrl() + "/v1/synthesize").addParameter("voice", voice).addParameter("text", text).build();

            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpGet httpget = new HttpGet(uri);
            httpget.addHeader("Authorization", credentials.
                    createAuthorizationHeaderValue());
            httpget.addHeader("Accept", "audio/ogg; codecs=opus");
            CloseableHttpResponse response = httpclient.execute(httpget);
            int statusCode = response.getStatusLine().getStatusCode();
			if(statusCode != 200) {
            	org.apache.http.HttpEntity entity = response.getEntity();
            	
            	System.err.println(EntityUtils.toString(entity));
            	
            	throw new RuntimeException("Service failed!");
            }
            try {
                org.apache.http.HttpEntity entity = response.getEntity();
                if (entity != null) {
                    return EntityUtils.toByteArray(entity);
                }
            } finally {
                response.close();
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return null;
    }

    protected ObjectMapper objectMapper = new ObjectMapper();

    public void init(GenericServiceConfig servicesConfig) {
        credentials = servicesConfig.getCredentials();
        doInit();
    }

    private void doInit() {
        restTemplate = new RestTemplate(
                new HttpComponentsClientHttpRequestFactory());

    }

}
