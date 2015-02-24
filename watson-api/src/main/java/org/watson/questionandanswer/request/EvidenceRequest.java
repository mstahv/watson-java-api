
package org.watson.questionandanswer.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EvidenceRequest {

    private Integer items;
    private String profile;

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
     *     The profile
     */
    public String getProfile() {
        return profile;
    }

    /**
     * 
     * @param profile
     *     The profile
     */
    public void setProfile(String profile) {
        this.profile = profile;
    }

}
