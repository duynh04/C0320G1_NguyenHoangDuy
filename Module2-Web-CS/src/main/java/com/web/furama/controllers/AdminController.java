package com.web.furama.controllers;

import com.web.furama.models.AttachFacility;
import com.web.furama.models.Customer;
import com.web.furama.models.Facility;
import com.web.furama.searches.FilterCustomer;
import com.web.furama.services.AttachFacilityService;
import com.web.furama.services.ContractService;
import com.web.furama.services.CustomerService;
import com.web.furama.services.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    ContractService contractService;

    @Autowired
    CustomerService customerService;

    @Autowired
    AttachFacilityService attachFacilityService;

    @Autowired
    FacilityService facilityService;

    @GetMapping("")
    public String getAdminHome() {
        return "adminTemplates/home";
    }

    @GetMapping("customer")
    public ModelAndView showCustomers(@ModelAttribute("filter") FilterCustomer filterCustomer, @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        Specification<Customer> specs = customerService.getFilter(filterCustomer);
        ModelAndView modelAndView = new ModelAndView("customerTemplates/list");
        if(specs != null) {
            modelAndView.addObject("customers", customerService.findCustomerByCriteria(specs, page));
        } else {
            Page<Customer> pageCustomer = customerService.findAllCustomers(page);
            modelAndView.addObject("customers", pageCustomer);
        }
        modelAndView.addObject("filter", filterCustomer);
        return modelAndView;
    }

    @GetMapping("contract")
    public ModelAndView showContracts(@RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        return new ModelAndView("contractTemplates/list", "contracts", contractService.getAllContracts(page));
    }

    @GetMapping("attach")
    public ModelAndView showAttachFacilities(@RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        return new ModelAndView("attachFacilityTemplates/list", "attachFacilities", attachFacilityService.getAllAttachFacilities(page));
    }

    @GetMapping("attachcreate")
    public ModelAndView showAttachForm() {
        return new ModelAndView("attachFacilityTemplates/create", "attachFacility", new AttachFacility());
    }
    @GetMapping("facility")
    public ModelAndView showFacilities(@RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        return new ModelAndView("facilityTemplates/list", "facilities", facilityService.getAllFacilities(page));
    }

    @GetMapping("error")
    public String getErrorPage() {
        return "error403";
    }
//    @GetMapping("facilitycreate")
//    public ModelAndView showFacilitiesCreateForm() {
//        return new ModelAndView("facilityTemplates/create1", "facility", new Facility());
//    }
}
