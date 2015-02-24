package org.watson.questionandanswer.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class MetadataMap {

    private String _abstract;
    private String originalfile;
    private String title;
    private String corpusName;
    private String description;
    private String deepqaid;
    private String fileName;
    private String DOCNO;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The _abstract
     */
    public String getAbstract() {
        return _abstract;
    }

    /**
     * 
     * @param _abstract
     *     The abstract
     */
    public void setAbstract(String _abstract) {
        this._abstract = _abstract;
    }

    /**
     * 
     * @return
     *     The originalfile
     */
    public String getOriginalfile() {
        return originalfile;
    }

    /**
     * 
     * @param originalfile
     *     The originalfile
     */
    public void setOriginalfile(String originalfile) {
        this.originalfile = originalfile;
    }

    /**
     * 
     * @return
     *     The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return
     *     The corpusName
     */
    public String getCorpusName() {
        return corpusName;
    }

    /**
     * 
     * @param corpusName
     *     The corpusName
     */
    public void setCorpusName(String corpusName) {
        this.corpusName = corpusName;
    }

    /**
     * 
     * @return
     *     The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return
     *     The deepqaid
     */
    public String getDeepqaid() {
        return deepqaid;
    }

    /**
     * 
     * @param deepqaid
     *     The deepqaid
     */
    public void setDeepqaid(String deepqaid) {
        this.deepqaid = deepqaid;
    }

    /**
     * 
     * @return
     *     The fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * 
     * @param fileName
     *     The fileName
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * 
     * @return
     *     The DOCNO
     */
    public String getDOCNO() {
        return DOCNO;
    }

    /**
     * 
     * @param DOCNO
     *     The DOCNO
     */
    public void setDOCNO(String DOCNO) {
        this.DOCNO = DOCNO;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
