package com.example.orm.services.Impl;

import com.example.orm.dtos.FilterCustomer;
import com.example.orm.models.Blog;
import com.example.orm.models.Customer;
import com.example.orm.repositories.CustomerRepository;
import com.example.orm.services.*;
import com.example.orm.services.filters.CustomerSpecification;
import com.example.orm.services.filters.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Customer findCustomerById(long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Customer> findAllCustomers(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void saveCustomer(Customer customer) {
        customer.setStatus(true);
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(long id) {
        customerRepository.updateByStatus(id);
    }

    @Override
    public Page<Customer> findCustomerByFirstName(String firstName, Pageable pageable) {
        return customerRepository.findByFirstName(firstName, pageable);
    }

    @Override
    public Specification<Customer> getFilter(FilterCustomer filterCustomer) {
        List<CustomerSpecification> specs = new ArrayList<>();
        Specification<Customer> spec;
        if(filterCustomer.getFirstName() != null) {
            if (!filterCustomer.getFirstName().equals(""))
                specs.add(new CustomerSpecification(new SearchCriteria("firstName", "=", filterCustomer.getFirstName())));
            else
                filterCustomer.setFirstName(null);
        }
        if(filterCustomer.getProvince() != null) {
            if (!filterCustomer.getProvince().equals(""))
                specs.add(new CustomerSpecification(new SearchCriteria("name", "join", filterCustomer.getProvince())));
            else
                filterCustomer.setProvince(null);
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
    public Page<Customer> findCustomerByCriteria(Specification<Customer> spec, Pageable pageable) {
        return customerRepository.findAll(spec, pageable);
    }
}
