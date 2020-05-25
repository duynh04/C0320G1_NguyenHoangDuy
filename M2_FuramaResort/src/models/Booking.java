package models;

import commons.IData;

public class Booking implements IData {
    private Customer customer;
    public Booking() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    @Override
    public String[] gatherInfo() {
        int NUM_OF_FIELD = 3;
        String[] data = new String[NUM_OF_FIELD];
        data[1] = customer.getId();
        data[2] = customer.getService().getId();
        return data;
    }
}
