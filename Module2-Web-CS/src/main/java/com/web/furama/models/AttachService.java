package com.web.furama.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "attachservices")
@Getter
@Setter
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


}
