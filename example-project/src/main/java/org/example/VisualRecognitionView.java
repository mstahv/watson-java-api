package org.example;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.vaadin.viritin.layouts.MVerticalLayout;

import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Notification;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.vaadin.viritin.fields.MTable;
import org.watson.visualrecognition.VisualRecognitionService;
import org.watson.visualrecognition.response.Image;
import org.watson.visualrecognition.response.Label;
import pl.exsio.plupload.Plupload;
import pl.exsio.plupload.PluploadError;
import pl.exsio.plupload.PluploadFile;

/**
 *
 * @author Matti Tahvonen
 */
@CDIView
public class VisualRecognitionView extends MVerticalLayout implements View {

    @Inject
    VisualRecognitionService service;

    final Plupload uploader = new Plupload("Browse", FontAwesome.FILES_O);

    MTable<Label> results = new MTable<>(Label.class);

    @PostConstruct
    void init() {

//autostart the uploader after addind files
        uploader.addFilesAddedListener(new Plupload.FilesAddedListener() {
            @Override
            public void onFilesAdded(PluploadFile[] files) {
                uploader.start();
            }
        });

        uploader.addFileUploadedListener(new Plupload.FileUploadedListener() {

            @Override
            public void onFileUploaded(PluploadFile file) {
                System.out.println("Wahtsn");
                File uploadedFile = file.getUploadedFile();
                try {
                    Image imageData = service.recognize(FileUtils.
                            readFileToByteArray(uploadedFile));
                    results.setBeans(imageData.getLabels());
                } catch (IOException ex) {
                    Logger.getLogger(VisualRecognitionView.class.getName()).
                            log(Level.SEVERE, null, ex);
                }
            }
        });

        add(uploader, results);

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }

}
