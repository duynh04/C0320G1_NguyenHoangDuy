package com.example.exam.controllers;

import com.example.exam.dtos.CustomerDto;
import com.example.exam.dtos.FilterCustomer;
import com.example.exam.models.Customer;
import com.example.exam.models.CustomerType;
import com.example.exam.services.CustomerService;
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
@RequestMapping("customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @GetMapping("")
    public ModelAndView getHome(@ModelAttribute FilterCustomer filterCustomer,@RequestParam(value = "page", required = false, defaultValue = "1") int page ) {
        Specification<Customer> specs = customerService.getFilter(filterCustomer);
        ModelAndView modelAndView = new ModelAndView("customerTemplates/home");
        if(specs != null) {
            modelAndView.addObject("customers", customerService.findCustomerByCriteria(specs, page));
        } else {
            Page<Customer> pageCustomer = customerService.findAllCustomers(page);
            modelAndView.addObject("customers", pageCustomer);
        }
        modelAndView.addObject("filter", filterCustomer);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        return new ModelAndView("customerTemplates/create-form", "customer", new CustomerDto());
    }
    @PostMapping("/save")
    public String saveCustomer(@Valid @ModelAttribute("customer") CustomerDto customer, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new CustomerDto().validate(customer, bindingResult);
        if (bindingResult.hasErrors()) {
            return "customerTemplates/create-form";
        }
        redirectAttributes.addFlashAttribute("success", "Create new customer successfully!");
        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showUpdateForm(@PathVariable long id) {
        return new ModelAndView("customerTemplates/edit-form", "customer", customerService.findCustomerById(id));
    }
    @PostMapping("/edit")
    public String editCustomer(@Valid @ModelAttribute Customer customer, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
//        CustomerDto customerDto = new CustomerDto();
//        customerDto.validate(customer, bindingResult);
        if (bindingResult.hasErrors()) {
            return "customerTemplates/edit-form";
        }
        customerService.updateCustomer(customer);
        redirectAttributes.addFlashAttribute("success", "Update customer successfully!");
        return "redirect:/customers";
    }
    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable long id) {
        return new ModelAndView("customerTemplates/delete-form", "customer", customerService.findCustomerById(id));
    }

    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam long id, RedirectAttributes redirectAttributes) {
        customerService.deleteCustomer(id);
        redirectAttributes.addFlashAttribute("success", "Delete successfully!");
        return "redirect:/customers";
    }
    @ModelAttribute(value = "customerTypes")
    public List<CustomerType> getProvince() {
        return customerService.getCustomerTypes();
    }
}
