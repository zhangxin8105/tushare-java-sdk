package io.cjf.tusharejavasdk.dto.out;

import java.util.List;

public class Data {
    private List<String> fields;
    private List<List<Object>> items;
    private Boolean has_more;

    public List<String> getFields() {
        return fields;
    }

    public void setFields(List<String> fields) {
        this.fields = fields;
    }

    public List<List<Object>> getItems() {
        return items;
    }

    public void setItems(List<List<Object>> items) {
        this.items = items;
    }

    public Boolean getHas_more() {
        return has_more;
    }

    public void setHas_more(Boolean has_more) {
        this.has_more = has_more;
    }
}
