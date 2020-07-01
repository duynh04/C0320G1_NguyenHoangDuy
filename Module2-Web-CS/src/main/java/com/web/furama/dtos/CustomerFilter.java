package com.web.furama.dtos;


import com.web.furama.models.CustomerType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerFilter {
    private String name;
    private String birthday;
    private String customerType;
}
