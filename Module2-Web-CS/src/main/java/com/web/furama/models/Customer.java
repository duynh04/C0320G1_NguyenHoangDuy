package com.web.furama.models;


import com.web.furama.validations.UniqueEmail;
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
    @Pattern(regexp = "^KH-\\d{4}$")
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
    @Pattern(regexp = "^([-\\w.])+[a-zA-Z\\d]@(\\w+\\.)+(\\w+)$", message = "Email is wrong format")
    private String email;

    @Column(name = "customer_birthday")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    @Column(name = "customer_address")
//    @Pattern(regexp = "^\\w+$", message = "Invalid address")
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

    public void setId(long id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getIdCard() {
        return idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getAddress() {
        return address;
    }

    public boolean isStatus() {
        return status;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public Account getAccount() {
        return account;
    }
}
