package com.example.exam.services.impl;

import com.example.exam.dtos.CustomerDto;
import com.example.exam.dtos.FilterCustomer;
import com.example.exam.models.Customer;
import com.example.exam.models.CustomerType;
import com.example.exam.repositories.CustomerRepository;
import com.example.exam.repositories.CustomerTypeRepository;
import com.example.exam.services.CustomerService;
import com.example.exam.services.filters.CustomerSpecification;
import com.example.exam.services.filters.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    @Autowired
    private CustomerTypeRepository customerTypeRepository;

    @Override
    public Customer findCustomerById(long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Customer> findAllCustomers(int page) {
        Pageable pageable = PageRequest.of(page - 1, 3);
        return customerRepository.findAll(pageable);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void saveCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setPhoneNumber(customerDto.getPhoneNumber());
        customer.setName(customerDto.getName());
        customer.setGender(customerDto.getGender());
        customer.setIdCard(customerDto.getIdCard());
        customer.setEmail(customerDto.getEmail());
        customer.setBirthday(customerDto.getBirthday());
        customer.setAddress(customerDto.getAddress());
        customer.setCode(customerDto.getCode());
        customer.setCustomerType(customerDto.getCustomerType());
        customer.setStatus(true);
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(long id) {
        customerRepository.updateByStatus(id);
    }

    @Override
    public Page<Customer> findCustomerByName(String name, int page) {
        Pageable pageable = PageRequest.of(page - 1, 3);
        return customerRepository.findByName(name, pageable);
    }

    @Override
    public Specification<Customer> getFilter(FilterCustomer filterCustomer) {
        List<CustomerSpecification> specs = new ArrayList<>();
        Specification<Customer> spec;
        if(filterCustomer.getName() != null) {
            if (!filterCustomer.getName().equals(""))
                specs.add(new CustomerSpecification(new SearchCriteria("name", "like", filterCustomer.getName())));
            else
                filterCustomer.setName(null);
        }
        if(filterCustomer.getCode() != null) {
            if (!filterCustomer.getCode().equals(""))
                specs.add(new CustomerSpecification(new SearchCriteria("code", "like", filterCustomer.getCode())));
            else
                filterCustomer.setCode(null);
        }
        if (specs.size() != 0) {
            spec = Specification.where(specs.get(0));
            for (int i = 1; i < specs.size(); i++) {
                assert spec != null;
                spec = spec.and(specs.get(i));
            }
            return spec;
        }
        return null;
    }

    @Override
    public Page<Customer> findCustomerByCriteria(Specification<Customer> spec, int page) {
        Pageable pageable = PageRequest.of(page - 1, 3);
        return customerRepository.findAll(spec, pageable);
    }

    @Override
    public List<CustomerType> getCustomerTypes() {
        return customerTypeRepository.findAll();
    }
}
