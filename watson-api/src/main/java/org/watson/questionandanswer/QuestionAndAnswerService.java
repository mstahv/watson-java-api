package org.watson.questionandanswer;

import org.watson.questionandanswer.request.Question;
import org.watson.questionandanswer.request.QuestionAndAnswerRequest;
import org.watson.questionandanswer.response.ResponseData;
import org.watson.vcapservices.BluemixServices;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import java.util.List;

import org.watson.vcapservices.BasicAuthenticationFilter;
import org.watson.vcapservices.GenericCredentials;
import org.watson.vcapservices.GenericServiceConfig;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import javax.ws.rs.core.GenericType;
import org.watson.questionandanswer.response.QuestionAndAnswerResponse;

/**
 * A Question and Answer service facade. If VCAP_SERVICES don't contain your
 * credentials, call init method manually before usage.
 */
@ApplicationScoped
public class QuestionAndAnswerService {

    private JacksonJaxbJsonProvider provider = new JacksonJaxbJsonProvider();
    private ObjectMapper objectMapper = provider.locateMapper(Object.class, MediaType.APPLICATION_JSON_TYPE);

    private Client client;
    private WebTarget target;

    @Inject
    BluemixServices bluemixServices;

    @PostConstruct
    public void init() {

        List<GenericServiceConfig> qaList = bluemixServices.
                getQuestionAndAnswerConfig();
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
                    "question");
        } else {
            System.err.println(
                    "Warning, bleumix services couldn't read q&a config");
        }
    }

    public ResponseData askQuestion(
            String questionText, String dataset) {
        return askQuestion(new Question(questionText), dataset);
    }

    public ResponseData askQuestion(Question question, String dataset) {
        if (target == null) {
            // For some reason Liberty don't execute init method automatically
            init();
        }
        QuestionAndAnswerRequest request = new QuestionAndAnswerRequest(question);
        try {
            List<QuestionAndAnswerResponse> response = target.path(dataset).request(
                    MediaType.APPLICATION_JSON).post(Entity.json(request),
                            new GenericType<List<QuestionAndAnswerResponse>>() {
                            });
            return response.get(0).getQuestion();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
