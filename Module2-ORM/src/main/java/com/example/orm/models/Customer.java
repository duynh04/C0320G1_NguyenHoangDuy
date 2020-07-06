package com.example.orm.models;

import com.example.orm.validators.NameConstraint;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private long id;

    @Column(name = "customer_firstname")
    @NameConstraint(message = "Name must be between 2 and 30 characters")
    private String firstName;

    @NameConstraint(message = "Name must be between 2 and 30 characters")
    @Column(name = "customer_lastname")
    private String lastName;

    @Column(name = "customer_email")
    private String email;

    @Column(name = "customer_status")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "province_id")
    private Province province;

    public Customer() {
    }

    public Customer(long id, String firstName, String lastName, String email,  Province province) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.province = province;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail(){
        return  email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, Name='%s', Email='%s', Address='%s']",
                id, firstName, email, province.getName());
    }
}
