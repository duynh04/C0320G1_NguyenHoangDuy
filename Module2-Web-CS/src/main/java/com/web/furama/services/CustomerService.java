package com.web.furama.services;

import com.web.furama.dtos.AccountRegister;
import com.web.furama.models.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface CustomerService {
    Customer findCustomerById(long id);
    Customer findCustomerByEmail(String email);
    Page<Customer> findAllCustomers(Pageable pageable);

    void updateCustomer(Customer customer);

    void register(AccountRegister accountRegister);

    void deleteCustomer(long id);

    Page<Customer> findCustomerByName(String firstName, Pageable pageable);

//    Specification<Customer> getFilter(FilterCustomer filterCustomer);
//    Page<Customer> findCustomerByCriteria(Specification<Customer> spec, Pageable pageable);
}
