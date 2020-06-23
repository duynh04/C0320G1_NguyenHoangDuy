package com.web.furama.models;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private long id;

    @Pattern(regexp = "^KH-\\d{4}$", message = "Customer code must be KH-XXXX")
    @Column(name = "customer_code", length = 10, nullable = false)
    private String code;

    @Size(min = 2, max = 30, message = "The name is too long")
    @Column(name = "customer_name", columnDefinition = "nvarchar(30)", nullable = false)
    private String name;

    @Pattern(regexp = "^\\d{9}$", message = "ID Card format must be 9 number!")
    @Column(name = "customer_idcard", length = 9, nullable = false)
    private String idCard;
    @Pattern(regexp = "^((\\(\\+84\\))|0)9[01]\\d{7}$", message = "Phone number is wrong format")
    @Column(name = "customer_phonenumber")
    private String phoneNumber;

    @Pattern(regexp = "^([-\\w.])+[a-zA-Z\\d]@(\\w+\\.)+(\\w+)$", message = "Email is wrong format")
    @Column(name = "customer_email")
    private String email;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "customer_birthday")
    private LocalDate birthday;

    @Column(name = "customer_status")
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "customer_type_id")
    private CustomerType customerType;

    @OneToMany(mappedBy = "customer")
    private List<Contract> contracts;

    public Customer() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
