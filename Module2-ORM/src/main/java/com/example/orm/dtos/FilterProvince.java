package com.example.orm.dtos;

public class FilterProvince {
    private String name;

    public FilterProvince() {
    }

    public FilterProvince(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
