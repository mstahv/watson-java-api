package org.watson.questionandanswer.response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class SynonymList {

    private String partOfSpeech;
    private String value;
    private String lemma;
    private List<SynSet> synSet = new ArrayList<SynSet>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The partOfSpeech
     */
    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    /**
     * 
     * @param partOfSpeech
     *     The partOfSpeech
     */
    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    /**
     * 
     * @return
     *     The value
     */
    public String getValue() {
        return value;
    }

    /**
     * 
     * @param value
     *     The value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 
     * @return
     *     The lemma
     */
    public String getLemma() {
        return lemma;
    }

    /**
     * 
     * @param lemma
     *     The lemma
     */
    public void setLemma(String lemma) {
        this.lemma = lemma;
    }

    /**
     * 
     * @return
     *     The synSet
     */
    public List<SynSet> getSynSet() {
        return synSet;
    }

    /**
     * 
     * @param synSet
     *     The synSet
     */
    public void setSynSet(List<SynSet> synSet) {
        this.synSet = synSet;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
