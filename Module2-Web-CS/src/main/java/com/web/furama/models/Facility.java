package com.web.furama.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.List;

@Entity
@Table(name = "facilities")
@Getter
@Setter
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "facility_id")
    private long id;

    @Column(name = "facility_name")
    private String name;

    @Column(name = "facility_price")
    private double price;

    @Min(value = 30, message = "Area must be greater than 30 meters of square")
    @Column(name = "facility_area")
    private double area;

    @Min(value = 1)
    @Column(name = "facility_floor")
    private int floor;

    @Min(value = 1)
    @Column(name = "facility_max_person")
    private int maxPerson;

    @Column(name = "facility_status")
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "facility_type_id")
    private FacilityType facilityType;

    @OneToMany(mappedBy = "facility")
    private List<Contract> contracts;
}
