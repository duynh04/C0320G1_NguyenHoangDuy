package com.web.furama.services;

import com.web.furama.dtos.ContractDto;
import com.web.furama.models.AttachFacility;
import com.web.furama.models.Contract;
import com.web.furama.models.Customer;
import com.web.furama.models.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContractService {

    List<Facility> getAllFacilities();

    List<AttachFacility> getAllAttachFacilities();


    Page<Contract> getAllContracts(int page);

    void addNewContract(Contract contract);

    void makeContract(ContractDto contractDto, Customer customer);

    void getContractInfo(ContractDto contractDto);
}
