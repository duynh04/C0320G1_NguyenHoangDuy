package com.web.furama.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "facilitytypes")
@Getter
@Setter
public class FacilityType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "facility_type_id")
    private long id;

    @Column(name = "facility_type_name", length = 10)
    private String name;
}
