
package org.example;

import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import javax.annotation.PostConstruct;
import org.vaadin.viritin.label.RichText;
import org.vaadin.viritin.layouts.MVerticalLayout;

/**
 *
 * @author Matti Tahvonen
 */
@CDIView("")
public class AboutView extends MVerticalLayout implements View {
    
    @PostConstruct
    void init() {
        add(new RichText().withMarkDownResource("/about.md"));
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }

}
