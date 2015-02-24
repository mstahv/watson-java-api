
package org.watson.questionandanswer.request;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Filter {

    private String filterType;
    private String filterName;
    private String values;

    /**
     * 
     * @return
     *     The filterType
     */
    public String getFilterType() {
        return filterType;
    }

    /**
     * 
     * @param filterType
     *     The filterType
     */
    public void setFilterType(String filterType) {
        this.filterType = filterType;
    }

    /**
     * 
     * @return
     *     The filterName
     */
    public String getFilterName() {
        return filterName;
    }

    /**
     * 
     * @param filterName
     *     The filterName
     */
    public void setFilterName(String filterName) {
        this.filterName = filterName;
    }

    /**
     * 
     * @return
     *     The values
     */
    public String getValues() {
        return values;
    }

    /**
     * 
     * @param values
     *     The values
     */
    public void setValues(String values) {
        this.values = values;
    }

}
