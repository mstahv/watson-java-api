
package org.watson.questionandanswer.response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class ResponseData {

    private List<Qclasslist> qclasslist = new ArrayList<Qclasslist>();
    private List<Focuslist> focuslist = new ArrayList<Focuslist>();
    private List<Latlist> latlist = new ArrayList<Latlist>();
    private List<Evidencelist> evidencelist = new ArrayList<Evidencelist>();
    private List<SynonymList> synonymList = new ArrayList<SynonymList>();
    private String pipelineid;
    private Boolean formattedAnswer;
    private String category;
    private Integer items;
    private String status;
    private String id;
    private String questionText;
    private EvidenceRequest evidenceRequest;
    private List<Answer> answers = new ArrayList<Answer>();
    private List<Object> errorNotifications = new ArrayList<Object>();
    private String passthru;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The qclasslist
     */
    public List<Qclasslist> getQclasslist() {
        return qclasslist;
    }

    /**
     * 
     * @param qclasslist
     *     The qclasslist
     */
    public void setQclasslist(List<Qclasslist> qclasslist) {
        this.qclasslist = qclasslist;
    }

    /**
     * 
     * @return
     *     The focuslist
     */
    public List<Focuslist> getFocuslist() {
        return focuslist;
    }

    /**
     * 
     * @param focuslist
     *     The focuslist
     */
    public void setFocuslist(List<Focuslist> focuslist) {
        this.focuslist = focuslist;
    }

    /**
     * 
     * @return
     *     The latlist
     */
    public List<Latlist> getLatlist() {
        return latlist;
    }

    /**
     * 
     * @param latlist
     *     The latlist
     */
    public void setLatlist(List<Latlist> latlist) {
        this.latlist = latlist;
    }

    /**
     * 
     * @return
     *     The evidencelist
     */
    public List<Evidencelist> getEvidencelist() {
        return evidencelist;
    }

    /**
     * 
     * @param evidencelist
     *     The evidencelist
     */
    public void setEvidencelist(List<Evidencelist> evidencelist) {
        this.evidencelist = evidencelist;
    }

    /**
     * 
     * @return
     *     The synonymList
     */
    public List<SynonymList> getSynonymList() {
        return synonymList;
    }

    /**
     * 
     * @param synonymList
     *     The synonymList
     */
    public void setSynonymList(List<SynonymList> synonymList) {
        this.synonymList = synonymList;
    }

    /**
     * 
     * @return
     *     The pipelineid
     */
    public String getPipelineid() {
        return pipelineid;
    }

    /**
     * 
     * @param pipelineid
     *     The pipelineid
     */
    public void setPipelineid(String pipelineid) {
        this.pipelineid = pipelineid;
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
     *     The status
     */
    public String getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
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
     *     The answers
     */
    public List<Answer> getAnswers() {
        return answers;
    }

    /**
     * 
     * @param answers
     *     The answers
     */
    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    /**
     * 
     * @return
     *     The errorNotifications
     */
    public List<Object> getErrorNotifications() {
        return errorNotifications;
    }

    /**
     * 
     * @param errorNotifications
     *     The errorNotifications
     */
    public void setErrorNotifications(List<Object> errorNotifications) {
        this.errorNotifications = errorNotifications;
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

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
