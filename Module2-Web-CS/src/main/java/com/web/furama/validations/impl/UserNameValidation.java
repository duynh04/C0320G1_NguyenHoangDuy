package com.web.furama.validations.impl;

import com.web.furama.models.Account;
import com.web.furama.services.AccountService;
import com.web.furama.validations.UniqueUserName;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserNameValidation implements ConstraintValidator<UniqueUserName, String> {

    @Autowired
    AccountService accountService;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Account accounts = accountService.getAccountByUserName(value);
        return accounts == null;
    }
}
