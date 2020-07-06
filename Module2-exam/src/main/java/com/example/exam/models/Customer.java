package com.example.exam.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private long id;

    @Column(name = "customer_code", length = 10, nullable = true)
    @Pattern(regexp = "^KH-\\d{4}$")
    private String code;

    @Column(name = "customer_name", columnDefinition = "nvarchar(30)")
    private String name;

    @Column(name = "customer_gender", columnDefinition = "nvarchar(10)")
    private String gender;

    @Column(name = "customer_idcard", length = 9)
    @Pattern(regexp = "^\\d{9}$", message = "ID Card format must be 9 number!")
    private String idCard;

    @Column(name = "customer_phonenumber")
    @Pattern(regexp = "^\\d{4}\\.\\d{3}\\.\\d{3}$", message = "Phone number is wrong format")
    private String phoneNumber;

    @Column(name = "customer_email")
    @Pattern(regexp = "^([-\\w.])+[a-zA-Z\\d]@(\\w+\\.)+(\\w+)$", message = "Email is wrong format")
    private String email;

    @Column(name = "customer_birthday")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    @Column(name = "customer_address")
    private String address;

    @Column(name = "customer_status")
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "customer_type_id")
    private CustomerType customerType;


}
