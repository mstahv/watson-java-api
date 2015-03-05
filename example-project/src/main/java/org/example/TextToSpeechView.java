package org.example;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.vaadin.viritin.button.PrimaryButton;
import org.vaadin.viritin.fields.MTextField;
import org.vaadin.viritin.fields.TypedSelect;
import org.vaadin.viritin.layouts.MVerticalLayout;
import org.watson.texttospeech.TextToSpeechService;

import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.StreamResource;
import com.vaadin.ui.Audio;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;

/**
 *
 * @author Matti Tahvonen
 */
@CDIView
public class TextToSpeechView extends MVerticalLayout implements View {

	@Inject
	TextToSpeechService service;

	TextField sayfield = new MTextField("What to say:").withFullWidth();
	
	TypedSelect<String> voices;

	PrimaryButton say = new PrimaryButton("Watson, please.",
			new Button.ClickListener() {

				@Override
				public void buttonClick(Button.ClickEvent event) {
					String text = sayfield.getValue();
                    final byte[] ogg = service.textToOgg(text, voices.getValue());
					Audio audio = new Audio("Watson says...", toStreamResource(ogg));
					addComponent(audio);
					audio.play();
				}
			});

	@PostConstruct
	void init() {
		voices = new TypedSelect<String>(String.class).withCaption("Use voice");
		voices.setOptions(service.getAvailableVoices());
		voices.selectFirst();
		
		sayfield.setValue("Watson thinks Vaadin and Bluemix is an awesome combination!");
		add(new Label(
				"Note, you need a browser with Ogg voice format support like Chrome or Firefox."),
				voices, sayfield, say);
	}

	@Override
	public void enter(ViewChangeListener.ViewChangeEvent event) {
	}
	
	private StreamResource toStreamResource(final byte[] ogg) {
		StreamResource resource = new StreamResource(
				new StreamResource.StreamSource() {
					@Override
					public InputStream getStream() {
						return new ByteArrayInputStream(ogg);
					}
				}, "watson.ogg");
		resource.setMIMEType("audio/ogg");
		return resource;
	}


}
