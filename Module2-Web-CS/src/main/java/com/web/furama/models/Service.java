package com.web.furama.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.List;

@Entity
@Table(name = "services")
@Getter
@Setter
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private long id;

    @Column(name = "service_name")
    private String name;

    @Column(name = "service_price")
    private double price;

    @Min(value = 30, message = "Area must be greater than 30 meters of square")
    @Column(name = "service_area")
    private double area;

    @Min(value = 1)
    @Column(name = "service_floor")
    private int floor;

    @Min(value = 1)
    @Column(name = "service_max_person")
    private int maxPerson;


    @Column(name = "service_status")
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "service_type_id")
    private ServiceType serviceType;

    @OneToMany(mappedBy = "service")
    private List<Contract> contracts;
}
