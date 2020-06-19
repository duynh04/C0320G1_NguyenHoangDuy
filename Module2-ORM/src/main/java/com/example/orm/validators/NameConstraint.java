package com.example.orm.validators;

import com.example.orm.validators.Impl.NameValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = NameValidation.class)
@Target(value = {ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NameConstraint {
    String message() default "Invalid Name";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
