package com.decathlon.common.util.extjs;

/**
 * This class is for create object of Filter
 * Created by DengYuanqin on 3/23/2016.
 */
public class FilterRequest {
    //[property:value]
    private String property;
    private String value;

    public FilterRequest() {
    }

    public FilterRequest(String property, String value) {
        this.property = property;
        this.value = value;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
