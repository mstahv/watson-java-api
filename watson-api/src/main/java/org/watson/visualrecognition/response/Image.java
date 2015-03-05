
package org.watson.visualrecognition.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 *
 * @author Matti Tahvonen
 */
public class Image {
    
    @JsonProperty("image_name")
    private String imageName;
    
    private List<Label> labels;

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }
    
    

}
