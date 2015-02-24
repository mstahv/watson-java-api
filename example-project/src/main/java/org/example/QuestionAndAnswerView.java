package org.example;

import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextField;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.vaadin.viritin.button.PrimaryButton;
import org.vaadin.viritin.fields.MTextField;
import org.vaadin.viritin.label.RichText;
import org.vaadin.viritin.layouts.MVerticalLayout;
import org.watson.questionandanswer.QuestionAndAnswerService;
import org.watson.questionandanswer.response.Evidencelist;
import org.watson.questionandanswer.response.ResponseData;

/**
 *
 * @author Matti Tahvonen
 */
@CDIView("")
public class QuestionAndAnswerView extends MVerticalLayout implements View {

    @Inject
    QuestionAndAnswerService service;

    final TextField question = new MTextField("Ask a question about travel:")
            .withFullWidth();
    PrimaryButton ask = new PrimaryButton("Watson, what do you think?",
            new Button.ClickListener() {

                @Override
                public void buttonClick(Button.ClickEvent event) {
                    String questionText = question.getValue();
                    ResponseData test = service.askQuestion(questionText);

                    StringBuilder sb = new StringBuilder();
                    for (Evidencelist a : test.getEvidencelist()) {
                        sb.append("# ").append(a.getTitle())
                        .append("\n Confidence: ").append(a.getValue())
                        .append("\n **Answer:** ").append(a.getText())
                        .append("\n");
                    }
                    answer.withMarkDown(sb.toString());
                }
            });
    RichText answer = new RichText();

    @PostConstruct
    void init() {
        question.setValue("What could I do in Tenerife?");
        add(question, ask, answer);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }

}
