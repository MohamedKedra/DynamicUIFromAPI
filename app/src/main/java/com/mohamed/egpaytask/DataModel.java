package com.mohamed.egpaytask;

public class DataModel {

    int id;
    String name, type, default_value, multiple, sort;
    boolean required;

    public DataModel(int id, String name, String type, String default_value, String multiple, String sort, boolean required) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.default_value = default_value;
        this.multiple = multiple;
        this.sort = sort;
        this.required = required;
    }
}
