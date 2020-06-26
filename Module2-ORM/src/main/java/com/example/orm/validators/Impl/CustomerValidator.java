package com.example.orm.validators.Impl;

import com.example.orm.models.Customer;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.ConstraintViolation;
import java.util.Set;

public class CustomerValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Customer.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "email", "email.empty1");
        Customer customer = (Customer)target;
        String EMAIL_REGEX = "^([-\\w.])+[a-zA-Z\\d]@(\\w+\\.)+(\\w+)$";
        if (!customer.getEmail().matches(EMAIL_REGEX)) {
            errors.rejectValue("email", "email.wrongFormat");
        }
    }
}
