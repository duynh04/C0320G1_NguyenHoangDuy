package com.example.orm.dtos;

import com.example.orm.models.Province;

public class FilterCustomer {

    private String firstName;
    private String lastName;
    private String email;
    private String province;

    public FilterCustomer(String firstName, String lastName, String email, String province) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.province = province;
    }

    public FilterCustomer() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
