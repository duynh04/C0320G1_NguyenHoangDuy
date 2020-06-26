package com.web.furama.controllers;

import com.web.furama.models.Customer;
import com.web.furama.searches.FilterCustomer;
import com.web.furama.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @GetMapping("")
    public ModelAndView getHome(@ModelAttribute FilterCustomer filterCustomer, @PageableDefault(value = 2) Pageable pageable) {
//        Specification<Customer> specs = customerService.getFilter(filterCustomer);
        ModelAndView modelAndView = new ModelAndView("customerTemplate/home");
//        if(specs != null) {
//            modelAndView.addObject("customers", customerService.findCustomerByCriteria(specs, pageable));
//        } else {
//            Page<Customer> pageCustomer = customerService.findAllCustomers(pageable);
//            modelAndView.addObject("customers", pageCustomer);
//        }
        modelAndView.addObject("filter", filterCustomer);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        return new ModelAndView("login", "customer", new Customer());
    }
    @PostMapping("/save")
    public String saveCustomer(@Valid @ModelAttribute Customer customer, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
//        CustomerValidator vali = new CustomerValidator();
//        vali.validate(customer, bindingResult);
//        if (bindingResult.hasErrors()) {
//            return "customerTemplate/create-form";
//        }
        redirectAttributes.addFlashAttribute("success", "Create new customer successfully!");
//        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }
}
