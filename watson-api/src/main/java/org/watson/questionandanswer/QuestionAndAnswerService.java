package org.watson.questionandanswer;

import java.nio.charset.Charset;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.apache.commons.codec.binary.Base64;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.watson.questionandanswer.request.Question;
import org.watson.questionandanswer.request.QuestionAndAnswerRequest;
import org.watson.questionandanswer.response.QuestionAndAnswerResponse;
import org.watson.questionandanswer.response.ResponseData;
import org.watson.vcapservices.BluemixServices;
import org.watson.vcapservices.Credentials;
import org.watson.vcapservices.QuestionAndAnswerConfig;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * A Question and Answer service facade. If VCAP_SERVICES don't contain your
 * credentials, call init method manually before usage.
 */
@ApplicationScoped
public class QuestionAndAnswerService {

    RestTemplate restTemplate;

    @Inject
    BluemixServices bluemixServices;
    private Credentials credentials;

    @PostConstruct
    public void init() {

        List<QuestionAndAnswerConfig> qaList = bluemixServices
                .getQuestionAndAnswerConfig();
        if (qaList != null && !qaList.isEmpty()) {
            credentials = qaList.get(0).getCredentials();
            doInit();
        } else {
            System.err
                    .println(
                            "Warning, bleumix services couldn't read q&a config");
        }
    }

    public ResponseData askQuestion(String questionText) {
        return askQuestion(new Question(questionText));
    }

    private HttpHeaders createHeaders() {
        return new HttpHeaders() {
            {
                String auth = credentials.getUsername() + ":" + credentials.getPassword();
                byte[] encodedAuth = Base64.encodeBase64(
                        auth.getBytes(Charset.forName("US-ASCII")));
                String authHeader = "Basic " + new String(encodedAuth);
                set("Authorization", authHeader);
                setContentType(MediaType.APPLICATION_JSON);
                set("Accept", "application/json");
            }
        };
    }

    public ResponseData askQuestion(Question question) {
        if (restTemplate == null) {
            // For some reason Liberty don't execute init method automatically
            init();
        }
        QuestionAndAnswerRequest request = new QuestionAndAnswerRequest(
                question);
        try {

            String json = objectMapper.writeValueAsString(request);
            final HttpHeaders createHeaders = createHeaders();
            HttpEntity<String> httpEntity = new HttpEntity<>(json, createHeaders);
            
            ResponseEntity<List<QuestionAndAnswerResponse>> response = restTemplate.
                    exchange(credentials.getUrl() + "/v1/question/travel",
                            HttpMethod.POST, httpEntity,
                            new ParameterizedTypeReference<List<QuestionAndAnswerResponse>>() {
                            });
            return response.getBody().get(0).getQuestion();

            // String writeValueAsString = new
            // ObjectMapper().writeValueAsString(request);
            // Response post =
            // target.request(MediaType.APPLICATION_JSON).post(Entity.text(writeValueAsString));
            // if(post.getStatus() == 500) {
            // String readEntity = post.readEntity(String.class);
            // System.out.println(readEntity);
            // }
            //
            // String response = target.request(
            // MediaType.APPLICATION_JSON).post(Entity.json(request),
            // String.class);
            // System.out.println(response);
            // return null;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    protected ObjectMapper objectMapper = new ObjectMapper();

    public void init(QuestionAndAnswerConfig servicesConfig) {
        credentials = servicesConfig.getCredentials();
        doInit();
    }

    private void doInit() {
        restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());

    }

}
