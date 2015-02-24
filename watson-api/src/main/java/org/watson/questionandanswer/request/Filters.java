
package org.watson.questionandanswer.request;

import java.util.ArrayList;
import java.util.List;

public class Filters {

    private List<Filter> filters = new ArrayList<Filter>();

    /**
     * 
     * @return
     *     The filters
     */
    public List<Filter> getFilters() {
        return filters;
    }

    /**
     * 
     * @param filters
     *     The filters
     */
    public void setFilters(List<Filter> filters) {
        this.filters = filters;
    }

}
