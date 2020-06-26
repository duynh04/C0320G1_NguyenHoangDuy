package com.web.furama.dtos;

import com.web.furama.validations.UniqueEmail;
import com.web.furama.validations.UniqueUserName;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

@Setter
@Getter
public class AccountRegister implements Validator {

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
        AccountRegister accountRegister = (AccountRegister)target;
        if(!accountRegister.confirm.equals(accountRegister.password))
            errors.rejectValue("confirm", "reg.confirm.notequal");
    }
}
