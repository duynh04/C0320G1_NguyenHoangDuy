package com.web.furama.dtos;

import com.web.furama.models.Account;
import com.web.furama.services.AccountService;
import com.web.furama.validations.UniqueEmail;
import com.web.furama.validations.UniqueUserName;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;
import java.util.List;

@Setter
@Getter
@Component
public class AccountRegister implements Validator {

    @Autowired
    AccountService accountService;

    @NotBlank
    @UniqueUserName(message = "username existed!")
    private String userName;

    @NotBlank
    private String password;

    @NotBlank
    private String confirm;

    @Pattern(regexp = "^([-\\w.])+[a-zA-Z\\d]@(\\w+\\.)+(\\w+)$", message = "Email is wrong format")
    @UniqueEmail(message = "This email have already registered!")
    private String email;

    @Override
    public boolean supports(Class<?> clazz) {
        return AccountRegister.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        List<Account> accountList = accountService.getAllAccount();
        AccountRegister accountRegister = (AccountRegister)target;
        if(!accountRegister.confirm.equals(accountRegister.password))
            errors.rejectValue("confirm", "reg.confirm.notequal");
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AccountService getAccountService() {
        return accountService;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirm() {
        return confirm;
    }

    public String getEmail() {
        return email;
    }
}
