package com.web.furama.dtos;

import com.web.furama.models.AttachFacility;
import com.web.furama.models.Customer;
import com.web.furama.models.Facility;
import com.web.furama.services.CustomerService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ContractDto {


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    private long noNights;
    private double totalPrice;

    private boolean status;

//    @ManyToOne
//    @JoinColumn(name = "customer_id")
    private Customer customer;

//    @ManyToOne
//    @JoinColumn(name = "service_id")
    private int facilityId;

//    @ManyToMany
//    @JoinTable(name = "contract_detail")
    private int[] attachFacilities;

    private List<AttachFacility> attachFacilityList;

    private Facility facility;

    public ContractDto() {
        attachFacilityList = new ArrayList<>();
    }

    public void addAttachFacility(AttachFacility attachFacility) {
        attachFacilityList.add(attachFacility);
    }

}
