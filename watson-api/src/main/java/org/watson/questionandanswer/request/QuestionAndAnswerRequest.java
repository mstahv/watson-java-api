
package org.watson.questionandanswer.request;

public class QuestionAndAnswerRequest {

    private Question question;

    public QuestionAndAnswerRequest(Question question) {
        this.question = question;
    }

    public QuestionAndAnswerRequest() {
    }

    /**
     * 
     * @return
     *     The question
     */
    public Question getQuestion() {
        return question;
    }

    /**
     * 
     * @param question
     *     The question
     */
    public void setQuestion(Question question) {
        this.question = question;
    }

}
