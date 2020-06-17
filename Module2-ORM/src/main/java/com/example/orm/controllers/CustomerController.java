package com.example.orm.controllers;

import com.example.orm.models.Customer;
import com.example.orm.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@Controller
@RequestMapping("products")

public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("")
    public String getHome() {
        return "home";
    }
    @PostMapping("/add")
    public @ResponseBody String addProduct (@RequestParam String name) {
        Customer customer = new Customer();
        customer.setName("Alex");
        customer.setEmail("alex@gmail.com");
        customer.setAddress("Da Nang");
        customerRepository.save(customer);
        return "saved";
    }
    @GetMapping("/allName")
    public @ResponseBody List<Customer> getByName() {
        return customerRepository.findByName("toan");
    }
    @GetMapping("/all")
    public @ResponseBody Iterable<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
