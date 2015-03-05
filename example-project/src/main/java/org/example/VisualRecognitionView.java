package org.example;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.vaadin.viritin.layouts.MVerticalLayout;

import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Upload;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import org.vaadin.viritin.fields.MTable;
import org.watson.visualrecognition.VisualRecognitionService;
import org.watson.visualrecognition.response.Image;
import org.watson.visualrecognition.response.Label;

/**
 *
 * @author Matti Tahvonen
 */
@CDIView
public class VisualRecognitionView extends MVerticalLayout implements View {

    @Inject
    VisualRecognitionService service;

    MTable<Label> results = new MTable<>(Label.class);
    
    ByteArrayOutputStream bout = new ByteArrayOutputStream();

    @PostConstruct
    void init() {

        Upload upload = new Upload("Choose JPG image", new Upload.Receiver() {

            @Override
            public OutputStream receiveUpload(String filename,
                    String mimeType) {
                return bout;
            }
        });
        upload.setIcon(FontAwesome.FILES_O);
        upload.setImmediate(true);
        upload.addSucceededListener(new Upload.SucceededListener() {

            @Override
            public void uploadSucceeded(Upload.SucceededEvent event) {
                Image imageData = service.recognize(bout.toByteArray());
                results.setBeans(imageData.getLabels());
                bout.reset();
            }
        });

        add(upload, results);

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }

}
