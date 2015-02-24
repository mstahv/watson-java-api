package org.watson.questionandanswer;


import org.jboss.resteasy.client.jaxrs.BasicAuthentication;
import org.watson.questionandanswer.request.Question;
import org.watson.questionandanswer.request.QuestionAndAnswerRequest;
import org.watson.questionandanswer.response.QuestionAndAnswerResponse;
import org.watson.questionandanswer.response.ResponseData;
import org.watson.vcapservices.BluemixServices;
import org.watson.vcapservices.Credentials;
import org.watson.vcapservices.QuestionAndAnswerConfig;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * A Question and Answer service facade. If VCAP_SERVICES don't contain your
 * credentials, call init method manually before usage.
 */
@ApplicationScoped
public class QuestionAndAnswerService {

    private Client client;
    private WebTarget target;

    @Inject
    BluemixServices bluemixServices;

    @PostConstruct
    public void init() {

        List<QuestionAndAnswerConfig> qaList = bluemixServices.
                getQuestionAndAnswerConfig();
        if (qaList != null && !qaList.isEmpty()) {
            final Credentials credentials = qaList.get(0).getCredentials();

            client = ClientBuilder.newBuilder()
                    .register(new BasicAuthentication(credentials.
                            getUsername(), credentials.
                            getPassword()))
                    .build();

            target = client.target(credentials.getUrl()).path("v1").path(
                    "question").path("travel");
        } else {
            System.err.println("Warning, bleumix services couldn't read q&a config");
        }
    }

    public ResponseData askQuestion(
            String questionText) {
        return askQuestion(new Question(questionText));
    }
    
    public ResponseData askQuestion(Question question) {
        if(target == null) {
            // For some reason Liberty don't execute init method automatically
            init();
        }
        QuestionAndAnswerRequest request = new QuestionAndAnswerRequest(question);
        try {
            List<QuestionAndAnswerResponse> response = target.request(
                    MediaType.APPLICATION_JSON).post(Entity.json(request),
                            new GenericType<List<QuestionAndAnswerResponse>>() {
                            });
            return response.get(0).getQuestion();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void init(QuestionAndAnswerConfig servicesConfig) {
        doInit(servicesConfig);
    }

    private void doInit(QuestionAndAnswerConfig servicesConfig) {
        final Credentials credentials = servicesConfig.getCredentials();

        client = ClientBuilder.newBuilder()
                .register(new BasicAuthentication(credentials.
                                getUsername(), credentials.
                                getPassword()))
                .build();

        target = client.target(credentials.getUrl()).path("v1").path(
                "question").path("travel");
    }

}
