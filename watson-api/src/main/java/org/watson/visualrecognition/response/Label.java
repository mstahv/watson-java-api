package org.watson.visualrecognition.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Matti Tahvonen
 */
public class Label {

    @JsonProperty(value = "label_name")
    private String labelName;

    @JsonProperty(value = "label_score")
    private Double labelScore;

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public Double getLabelScore() {
        return labelScore;
    }

    public void setLabelScore(Double labelScore) {
        this.labelScore = labelScore;
    }

}
