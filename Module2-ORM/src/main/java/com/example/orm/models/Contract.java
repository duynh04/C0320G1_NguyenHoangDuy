package com.example.orm.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name = "contracts")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @ManyToMany
    @JoinTable(name = "contract_service")
    private List<AttachService> attachServices;

    public Contract() {
        attachServices = new ArrayList<>();
    }

    public void addAttachService(AttachService attachService) {
        this.attachServices.add(attachService);
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

    public List<AttachService> getAttachServices() {
        return attachServices;
    }

    public void setAttachServices(List<AttachService> attachServices) {
        this.attachServices = attachServices;
    }
}
