package com.web.furama.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "servicetypes")
@Getter
@Setter
public class ServiceType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_type_id")
    private long id;

    @Column(name = "service_type_name", length = 10)
    private String name;
}
