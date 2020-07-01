package com.web.furama.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.xml.bind.annotation.XmlInlineBinaryData;
import java.util.List;

@Entity
@Table(name = "attachfacilities")
@Getter
@Setter
public class AttachFacility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attach_facility_id")
    private long id;

    @Column(name = "attach_facility_name")
    private String name;

    @Column(name = "attach_facility_price")
    @Min(value = 0, message = "Price must be greater than 0.")
    private double price;

    @Column(name = "attach_facility_status")
    private boolean status;

    @ManyToMany(mappedBy = "attachFacilities")
    private List<Contract> contracts;

    public AttachFacility() {
    }

    public AttachFacility(long id)  {
        this.id = id;
    }
}
