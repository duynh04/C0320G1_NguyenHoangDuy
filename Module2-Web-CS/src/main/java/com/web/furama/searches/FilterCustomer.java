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
}