package com.web.furama.services;

import com.web.furama.dtos.AccountRegister;
import com.web.furama.dtos.CustomerDto;
import com.web.furama.models.Customer;
import com.web.furama.models.CustomerType;
import com.web.furama.searches.FilterCustomer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface CustomerService {
    List<CustomerType> getCustomerTypes();
    Customer findCustomerById(long id);
    Customer findCustomerByEmail(String email);
    Page<Customer> findAllCustomers(int page);

    void updateCustomer(Customer customer);

    void register(AccountRegister accountRegister, CustomerDto customerDto);

    void deleteCustomer(long id);

    Page<Customer> findCustomerByName(String firstName, Pageable pageable);

    Specification<Customer> getFilter(FilterCustomer filterCustomer);
    Page<Customer> findCustomerByCriteria(Specification<Customer> spec, int page);
}
