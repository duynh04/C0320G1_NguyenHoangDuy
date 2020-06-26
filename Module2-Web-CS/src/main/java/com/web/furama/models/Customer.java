package com.web.furama.models;


import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "customers")
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private long id;

    @Column(name = "customer_code", length = 10, nullable = true)
    @Size(min = 2, max = 30, message = "The name is too long")
    private String code;

    @Column(name = "customer_name", columnDefinition = "nvarchar(30)", nullable = true)
    private String name;

    @Column(name = "customer_idcard", length = 9, nullable = true)
    @Pattern(regexp = "^\\d{9}$", message = "ID Card format must be 9 number!")
    private String idCard;

    @Column(name = "customer_phonenumber")
    @Pattern(regexp = "^((\\(\\+84\\))|0)9[01]\\d{7}$", message = "Phone number is wrong format")
    private String phoneNumber;

    @Column(name = "customer_email")
    private String email;

    @Column(name = "customer_birthday")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthday;

    @Column(name = "customer_address")
    @Pattern(regexp = "^\\w+$", message = "Invalid address")
    private String address;

    @Column(name = "customer_status")
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "customer_type_id")
    private CustomerType customerType;

    @OneToMany(mappedBy = "customer")
    private List<Contract> contracts;

    @OneToOne(mappedBy = "customer")
    private Account account;
}
