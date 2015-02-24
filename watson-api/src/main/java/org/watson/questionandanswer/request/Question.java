
package org.watson.questionandanswer.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
@JsonInclude(Include.NON_NULL)
public class Question {

    private String questionText;
    private Integer items;
    private EvidenceRequest evidenceRequest;
    private String answerAssertion;
    private String category;
    private String context;
    private Boolean formattedAnswer;
    private String passthru;
    private String synonyms;
    private String lat;
    private Filters filters;

    public Question() {
    }

    public Question(String questionText) {
        this.questionText = questionText;
    }

    /**
     * 
     * @return
     *     The questionText
     */
    public String getQuestionText() {
        return questionText;
    }

    /**
     * 
     * @param questionText
     *     The questionText
     */
    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    /**
     * 
     * @return
     *     The items
     */
    public Integer getItems() {
        return items;
    }

    /**
     * 
     * @param items
     *     The items
     */
    public void setItems(Integer items) {
        this.items = items;
    }

    /**
     * 
     * @return
     *     The evidenceRequest
     */
    public EvidenceRequest getEvidenceRequest() {
        return evidenceRequest;
    }

    /**
     * 
     * @param evidenceRequest
     *     The evidenceRequest
     */
    public void setEvidenceRequest(EvidenceRequest evidenceRequest) {
        this.evidenceRequest = evidenceRequest;
    }

    /**
     * 
     * @return
     *     The answerAssertion
     */
    public String getAnswerAssertion() {
        return answerAssertion;
    }

    /**
     * 
     * @param answerAssertion
     *     The answerAssertion
     */
    public void setAnswerAssertion(String answerAssertion) {
        this.answerAssertion = answerAssertion;
    }

    /**
     * 
     * @return
     *     The category
     */
    public String getCategory() {
        return category;
    }

    /**
     * 
     * @param category
     *     The category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * 
     * @return
     *     The context
     */
    public String getContext() {
        return context;
    }

    /**
     * 
     * @param context
     *     The context
     */
    public void setContext(String context) {
        this.context = context;
    }

    /**
     * 
     * @return
     *     The formattedAnswer
     */
    public Boolean getFormattedAnswer() {
        return formattedAnswer;
    }

    /**
     * 
     * @param formattedAnswer
     *     The formattedAnswer
     */
    public void setFormattedAnswer(Boolean formattedAnswer) {
        this.formattedAnswer = formattedAnswer;
    }

    /**
     * 
     * @return
     *     The passthru
     */
    public String getPassthru() {
        return passthru;
    }

    /**
     * 
     * @param passthru
     *     The passthru
     */
    public void setPassthru(String passthru) {
        this.passthru = passthru;
    }

    /**
     * 
     * @return
     *     The synonyms
     */
    public String getSynonyms() {
        return synonyms;
    }

    /**
     * 
     * @param synonyms
     *     The synonyms
     */
    public void setSynonyms(String synonyms) {
        this.synonyms = synonyms;
    }

    /**
     * 
     * @return
     *     The lat
     */
    public String getLat() {
        return lat;
    }

    /**
     * 
     * @param lat
     *     The lat
     */
    public void setLat(String lat) {
        this.lat = lat;
    }

    /**
     * 
     * @return
     *     The filters
     */
    public Filters getFilters() {
        return filters;
    }

    /**
     * 
     * @param filters
     *     The filters
     */
    public void setFilters(Filters filters) {
        this.filters = filters;
    }

}
