package com.nsk.musiclib.controller.model.request;

public class GeneralQuery {
    private String field;
    private String value;

    public GeneralQuery() {
    }

    public GeneralQuery(String field, String value) {
        this.field = field;
        this.value = value;
    }

    public String getField() {
        return this.field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public GeneralQuery field(String field) {
        setField(field);
        return this;
    }

    public GeneralQuery value(String value) {
        setValue(value);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " field='" + getField() + "'" +
            ", value='" + getValue() + "'" +
            "}";
    }
    
}
