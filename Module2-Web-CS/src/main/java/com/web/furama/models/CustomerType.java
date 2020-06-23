package com.web.furama.models;


import javax.persistence.*;

@Entity
@Table(name = "customertypes")
public class CustomerType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_type_id")
    private long id;

    @Column(name = "customer_type_name", length = 10)
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CustomerType() {
    }


}
