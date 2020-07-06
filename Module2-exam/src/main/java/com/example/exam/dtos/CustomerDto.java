package com.example.exam.dtos;

import com.example.exam.models.Customer;
import com.example.exam.models.CustomerType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.Period;

@Getter
@Setter
public class CustomerDto implements Validator {

    @Pattern(regexp = "^KH-\\d{4}$", message = "Code must be KH-XXXX (X:0-9)")
    private String code;

    private String name;

    private String gender;

    @Pattern(regexp = "^\\d{9}$", message = "ID Card format must be 9 number!")
    private String idCard;

    @Pattern(regexp = "^\\d{4}\\.\\d{3}\\.\\d{3}$", message = "Phone number is wrong format")
    private String phoneNumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

//    @Pattern(regexp = "^\\w+$", message = "Invalid address")
    private String address;

    @Pattern(regexp = "^([-\\w.])+[a-zA-Z\\d]@(\\w+\\.)+(\\w+)$", message = "Email is wrong format")
    private String email;

    private CustomerType customerType;

    @Override
    public boolean supports(Class<?> clazz) {
        return CustomerDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        if (customerDto.getBirthday() == null) {
            errors.rejectValue("birthday", "birthday.format");
        } else {

//        check age
            LocalDate now = LocalDate.now(); //gets localDate
            Period diff = Period.between(customerDto.getBirthday(), now); //difference between the dates is calculated
            if (diff.getYears() < 18) {
                errors.rejectValue("birthday", "birthday.under");
            }
        }
    }
}
