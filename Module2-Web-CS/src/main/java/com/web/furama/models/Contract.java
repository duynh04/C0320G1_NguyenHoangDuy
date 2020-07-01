package com.web.furama.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "contracts")
@Setter
@Getter
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private long id;

    @Column(name = "contract_start_date")
    private LocalDate startDate;

    @Column(name = "contract_end_date")
    private LocalDate endDate;

    @Column(name = "contract_price")
    private double price;

    @Column(name = "contract_status")
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "facility_id")
    private Facility facility;

    @ManyToMany
    @JoinTable(name = "contract_detail")
    private List<AttachFacility> attachFacilities;


}
