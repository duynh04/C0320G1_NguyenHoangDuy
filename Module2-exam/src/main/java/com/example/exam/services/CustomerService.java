package com.example.exam.services;

import com.example.exam.dtos.CustomerDto;
import com.example.exam.dtos.FilterCustomer;
import com.example.exam.models.Customer;
import com.example.exam.models.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface CustomerService {
    List<CustomerType> getCustomerTypes();
    Customer findCustomerById(long id);
    Page<Customer> findAllCustomers(int page);
    void updateCustomer(Customer customer);
    void saveCustomer(CustomerDto customerDto);
    void deleteCustomer(long id);
    Page<Customer> findCustomerByName(String name,int page);
    Specification<Customer> getFilter(FilterCustomer filterCustomer);
    Page<Customer> findCustomerByCriteria(Specification<Customer> spec,int page);
}
