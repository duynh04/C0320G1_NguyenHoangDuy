package com.web.furama.validations;

import com.web.furama.validations.impl.UserNameValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = UserNameValidation.class)
@Target(value = {ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UniqueUserName {
    String message() default "Existed";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
