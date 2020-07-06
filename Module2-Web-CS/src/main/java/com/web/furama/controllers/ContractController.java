package com.web.furama.controllers;

import com.web.furama.dtos.ContractDto;
import com.web.furama.dtos.CustomerDto;
import com.web.furama.models.*;
import com.web.furama.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("contracts")
public class ContractController {

    @Autowired
    ContractService contractService;

    @Autowired
    AccountService accountService;

    @ModelAttribute("facilities")
    public List<Facility> getFacility(){
        return contractService.getAllFacilities();
    }

    @ModelAttribute("attaches")
    public List<AttachFacility> getAttachFacility() {
        return contractService.getAllAttachFacilities();
    }

    @GetMapping("")
    public ModelAndView showFacilityForm(){
        return new ModelAndView("contractTemplates/facility-create", "contract", new ContractDto());
    }

    @PostMapping("/attach")
    public ModelAndView showAttachFacilityForm(@ModelAttribute("contract") ContractDto contractDto){
        return new ModelAndView("contractTemplates/attach-create", "contract", contractDto);
    }

    @PostMapping("/detail")
    public ModelAndView showDetailForm(@ModelAttribute("contract") ContractDto contractDto){
        return new ModelAndView("contractTemplates/detail-create", "contract", contractDto);
    }

    @PostMapping("/info")
    public ModelAndView showInfoForm(@ModelAttribute("contract") ContractDto contractDto){
        contractService.getContractInfo(contractDto);
        return new ModelAndView("contractTemplates/info-create", "contract", contractDto);
    }

    @PostMapping("/save")
    public ModelAndView addNewContract(@ModelAttribute("contract") ContractDto contractDto, Principal principal){
        Customer customer =  accountService.getAccountByUserName(principal.getName()).getCustomer();
        contractService.makeContract(contractDto, customer);
        return new ModelAndView("contractTemplates/info-create", "contract", contractDto);
    }

    @GetMapping("/view")
    public ModelAndView showContracts(Principal principal) {
        Customer customer = accountService.getAccountByUserName(principal.getName()).getCustomer();
        ModelAndView modelAndView = new ModelAndView("contractTemplates/view");
        modelAndView.addObject("contracts", customer.getContracts());
        return modelAndView;
    }
}
