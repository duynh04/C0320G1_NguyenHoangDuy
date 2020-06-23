package com.example.orm.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "attachservices")
public class AttachService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private double price;

    @ManyToMany(mappedBy = "attachServices")
    //@JoinTable(name = "contract_service")
    private Set<Contract> contracts;

    public AttachService() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }
}
