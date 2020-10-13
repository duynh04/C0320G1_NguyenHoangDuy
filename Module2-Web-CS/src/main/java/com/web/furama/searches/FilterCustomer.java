package com.web.furama.searches;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilterCustomer {
    private String name;
    private String customerType;
    private String from;
    private String to;

    public void setName(String name) {
        this.name = name;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getName() {
        return name;
    }

    public String getCustomerType() {
        return customerType;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }
}