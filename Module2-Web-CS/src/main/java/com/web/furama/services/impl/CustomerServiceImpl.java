package com.web.furama.services.impl;

import com.web.furama.dtos.AccountRegister;
import com.web.furama.models.Account;
import com.web.furama.models.Authority;
import com.web.furama.models.Customer;
import com.web.furama.repositories.AccountRepository;
import com.web.furama.repositories.CustomerRepository;
import com.web.furama.services.AccountService;
import com.web.furama.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AccountService accountService;

    @Override
    public Customer findCustomerById(long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer findCustomerByEmail(String email) {
        return customerRepository.getCustomerByEmail(email);
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
    public void register(AccountRegister accountRegister) {
        Account account = new Account();
        account.setUserName(accountRegister.getUserName());
        account.setPassword(accountRegister.getPassword());

        Customer customer = new Customer();
        customer.setEmail(accountRegister.getEmail());
        customer.setStatus(true);
        customerRepository.save(customer);
        account.setCustomer(customer);
        accountService.saveNewAccount(account);
    }

    @Override
    public void deleteCustomer(long id) {
        customerRepository.updateByStatus(id);
    }

    @Override
    public Page<Customer> findCustomerByName(String name, Pageable pageable) {
        return customerRepository.findByName(name, pageable);
    }

//    @Override
//    public Specification<Customer> getFilter(FilterCustomer filterCustomer) {
//        List<CustomerSpecification> specs = new ArrayList<>();
//        Specification<Customer> spec;
//        if(filterCustomer.getFirstName() != null) {
//            if (!filterCustomer.getFirstName().equals(""))
//                specs.add(new CustomerSpecification(new SearchCriteria("firstName", "=", filterCustomer.getFirstName())));
//            else
//                filterCustomer.setFirstName(null);
//        }
//        if(filterCustomer.getProvince() != null) {
//            if (!filterCustomer.getProvince().equals(""))
//                specs.add(new CustomerSpecification(new SearchCriteria("name", "join", filterCustomer.getProvince())));
//            else
//                filterCustomer.setProvince(null);
//        }
//        if (specs.size() != 0) {
//            spec = Specification.where(specs.get(0));
//            for (int i = 1; i < specs.size(); i++) {
//                assert spec != null;
//                spec = spec.and(specs.get(i));
//            }
//            return spec;
//        }
//        return null;
//    }

//    @Override
//    public Page<Customer> findCustomerByCriteria(Specification<Customer> spec, Pageable pageable) {
//        return customerRepository.findAll(spec, pageable);
//    }
}
