package org.watson.questionandanswer.response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class SynSet {

    private String name;
    private List<Synonym> synonym = new ArrayList<Synonym>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The synonym
     */
    public List<Synonym> getSynonym() {
        return synonym;
    }

    /**
     * 
     * @param synonym
     *     The synonym
     */
    public void setSynonym(List<Synonym> synonym) {
        this.synonym = synonym;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}