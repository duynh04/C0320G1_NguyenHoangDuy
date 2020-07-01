package com.web.furama.services.impl;

import com.web.furama.dtos.ContractDto;
import com.web.furama.models.AttachFacility;
import com.web.furama.models.Contract;
import com.web.furama.models.Customer;
import com.web.furama.models.Facility;
import com.web.furama.repositories.ContractRepository;
import com.web.furama.services.AttachFacilityService;
import com.web.furama.services.ContractService;
import com.web.furama.services.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    ContractRepository contractRepository;

    @Autowired
    FacilityService facilityService;

    @Autowired
    AttachFacilityService attachFacilityService;

    @Override
    public Page<Contract> getAllContracts(int page) {
        Pageable pageable = PageRequest.of(page - 1, 4);
        return contractRepository.findAll(pageable);
    }

    @Override
    public List<Facility> getAllFacilities() {
        return facilityService.getAllFacilities();
    }

    @Override
    public List<AttachFacility> getAllAttachFacilities() {
        return attachFacilityService.getAllAttachFacilities();
    }

    @Override
    public void addNewContract(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public void makeContract(ContractDto contractDto, Customer customer) {
        getContractInfo(contractDto);
        Contract contract = new Contract();
//        //test
//        Customer customer = new Customer();
//        customer.setId(1);
        contract.setStartDate(contractDto.getStartDate());
        contract.setEndDate(contractDto.getEndDate());
//        //test
        contract.setCustomer(customer);
        contract.setAttachFacilities(contractDto.getAttachFacilityList());
        contract.setStatus(true);
        contract.setFacility(contractDto.getFacility());
        contract.setPrice(contractDto.getTotalPrice());
        contractRepository.save(contract);
//        return ;
//        return new Contract();
    }

    @Override
    public void getContractInfo(ContractDto contractDto) {
        List<Facility> facilities = getAllFacilities();
        List<AttachFacility> attachFacilities = getAllAttachFacilities();
        long nights = ChronoUnit.DAYS.between(contractDto.getStartDate(), contractDto.getEndDate());
        contractDto.setNoNights(nights);
        contractDto.setFacility(facilities.get(contractDto.getFacilityId() - 1));
        double totalPrice = contractDto.getFacility().getPrice() * nights;
        for (int item: contractDto.getAttachFacilities()) {
            contractDto.addAttachFacility(attachFacilities.get(item - 1));
            totalPrice += attachFacilities.get(item - 1).getPrice();
        }
        contractDto.setTotalPrice(totalPrice);
    }
}
