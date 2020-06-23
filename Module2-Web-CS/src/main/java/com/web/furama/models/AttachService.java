package com.web.furama.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "attachservices")
public class AttachService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attach_service_id")
    private long id;

    @Column(name = "attach_service_name")
    private String name;

    @Column(name = "attach_service_price")
    private double price;

    @Column(name = "attach_service_status")
    private boolean status;

    @ManyToMany(mappedBy = "attachServices")
    private List<Contract> contracts;

    public AttachService() {
    }

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
