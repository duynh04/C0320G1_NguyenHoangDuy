package com.example.exam.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "customertypes")
@Getter
@Setter
public class CustomerType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_type_id")
    private long id;

    @Column(name = "customer_type_name", length = 10)
    private String name;

    public CustomerType() {
    }
    public CustomerType(long id) {
        this.id = id;
    }

}
