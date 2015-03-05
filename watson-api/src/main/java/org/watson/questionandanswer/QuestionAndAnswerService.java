package org.watson.questionandanswer;

import org.watson.questionandanswer.request.Question;
import org.watson.questionandanswer.request.QuestionAndAnswerRequest;
import org.watson.questionandanswer.response.ResponseData;
import org.watson.BluemixServices;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import java.util.List;

import org.watson.GenericCredentials;
import org.watson.GenericServiceConfig;

import javax.ws.rs.core.GenericType;
import org.watson.questionandanswer.response.QuestionAndAnswerResponse;

/**
 * A Question and Answer service facade. If VCAP_SERVICES don't contain your
 * credentials, call init method manually before usage.
 */
@ApplicationScoped
public class QuestionAndAnswerService {

    @Inject
    private Client client;
    private WebTarget target;

    @Inject
    BluemixServices bluemixServices;

    @PostConstruct
    public void init() {

        GenericServiceConfig serviceConfig = bluemixServices.
                getQuestionAndAnswerConfig();
        final GenericCredentials credentials = serviceConfig.getCredentials();

        client.register(credentials);

        target = client.target(credentials.getUrl()).path("v1").path(
                "question");
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
            List<QuestionAndAnswerResponse> response = target.path(dataset).
                    request(
                            MediaType.APPLICATION_JSON).post(Entity.
                            json(request),
                            new GenericType<List<QuestionAndAnswerResponse>>() {
                            });
            return response.get(0).getQuestion();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
