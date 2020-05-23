package models;

import commons.IData;


public class Booking implements IData {
    private String customer;
    private String service;
    public Booking() {
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    @Override
    public String[] gatherInfo() {
        int NUM_OF_FIELD = 3;
        String[] data = new String[NUM_OF_FIELD];
        data[1] = customer;
        data[2] = service;
        return data;
    }
}
