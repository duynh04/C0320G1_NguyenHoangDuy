package com.web.furama.validations.impl;

import com.web.furama.models.Account;
import com.web.furama.models.Customer;
import com.web.furama.services.AccountService;
import com.web.furama.services.CustomerService;
import com.web.furama.validations.UniqueEmail;
import com.web.furama.validations.UniqueUserName;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidation implements ConstraintValidator<UniqueEmail, String> {

    @Autowired
    CustomerService customerService;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Customer customer = customerService.findCustomerByEmail(value);
        return customer == null;
    }
}
