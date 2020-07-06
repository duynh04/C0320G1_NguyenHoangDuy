package com.example.orm.controllers;

import com.example.orm.dtos.FilterCustomer;
import com.example.orm.models.*;
import com.example.orm.services.*;
import com.example.orm.validators.Impl.CustomerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
//@SessionAttributes("mycounter")
@RequestMapping("customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProvinceService provinceService;

    @GetMapping("")
    public ModelAndView getHome(@ModelAttribute FilterCustomer filterCustomer, @PageableDefault(value = 2) Pageable pageable) {
        Specification<Customer> specs = customerService.getFilter(filterCustomer);
        ModelAndView modelAndView = new ModelAndView("customerTemplate/home");
        if(specs != null) {
            modelAndView.addObject("customers", customerService.findCustomerByCriteria(specs, pageable));
        } else {
            Page<Customer> pageCustomer = customerService.findAllCustomers(pageable);
            modelAndView.addObject("customers", pageCustomer);
        }
        modelAndView.addObject("filter", filterCustomer);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        return new ModelAndView("customerTemplate/create-form", "customer", new Customer());
    }
    @PostMapping("/save")
    public String saveCustomer(@Valid @ModelAttribute Customer customer, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        CustomerValidator vali = new CustomerValidator();
        vali.validate(customer, bindingResult);
        if (bindingResult.hasErrors()) {
            return "customerTemplate/create-form";
        }
        redirectAttributes.addFlashAttribute("success", "Create new customer successfully!");
        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showUpdateForm(@PathVariable long id) {
        return new ModelAndView("customerTemplate/edit-form", "customer", customerService.findCustomerById(id));
    }
    @PostMapping("/edit")
    public String editCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        customerService.updateCustomer(customer);
        redirectAttributes.addFlashAttribute("success", "Update customer successfully!");
        return "redirect:/customers";
    }
    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable long id) {
        return new ModelAndView("customerTemplate/delete-form", "customer", customerService.findCustomerById(id));
    }

    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam long id, RedirectAttributes redirectAttributes) {
        customerService.deleteCustomer(id);
        redirectAttributes.addFlashAttribute("success", "Delete successfully!");
        return "redirect:/customers";
    }
    @ModelAttribute(value = "provinces")
    public List<Province> getProvince() {
        return provinceService.findAddProvinces();
    }
}
