package com.example.exam.services;

import com.example.orm.dtos.FilterCustomer;
import com.example.orm.models.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface CustomerService {
    Customer findCustomerById(long id);
    Page<Customer> findAllCustomers(Pageable pageable);

    void updateCustomer(Customer customer);

    void saveCustomer(Customer customer);

    void deleteCustomer(long id);

    Page<Customer> findCustomerByFirstName(String firstName, Pageable pageable);

    Specification<Customer> getFilter(FilterCustomer filterCustomer);
    Page<Customer> findCustomerByCriteria(Specification<Customer> spec, Pageable pageable);
}
