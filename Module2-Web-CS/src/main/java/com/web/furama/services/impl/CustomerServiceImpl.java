package com.web.furama.services.impl;

import com.web.furama.dtos.AccountRegister;
import com.web.furama.dtos.CustomerDto;
import com.web.furama.models.Account;
import com.web.furama.models.Authority;
import com.web.furama.models.Customer;
import com.web.furama.models.CustomerType;
import com.web.furama.repositories.CustomerRepository;
import com.web.furama.repositories.CustomerTypeRepository;
import com.web.furama.searches.FilterCustomer;
import com.web.furama.searches.specs.CustomerSpecifications;
import com.web.furama.searches.specs.SearchCriteria;
import com.web.furama.services.AccountService;
import com.web.furama.services.CustomerService;
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
    public Page<Customer> findAllCustomers(int page) {
        Pageable pageable = PageRequest.of(page - 1, 2);
        return customerRepository.findAll(pageable);
    }

    @Override
    public List<CustomerType> getCustomerTypes() {
        return customerTypeRepository.findAll();
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void register(AccountRegister accountRegister,CustomerDto customerDto) {
            Account account = new Account();
            account.setUserName(accountRegister.getUserName());
            account.setPassword(accountRegister.getPassword());

            Customer customer = new Customer();
            customer.setEmail(accountRegister.getEmail());
            customer.setStatus(true);
            customer.setCustomerType(new CustomerType(1));
            if (customerDto != null) {
                customer.setName(customerDto.getName());
                customer.setCustomerType(customerDto.getCustomerType());
                customer.setBirthday(customerDto.getBirthday());
                customer.setIdCard(customerDto.getIdCard());
                customer.setAddress(customerDto.getAddress());
                customer.setCode(customerDto.getCode());
                customer.setPhoneNumber(customerDto.getPhoneNumber());
            }
            customerRepository.save(customer);
            account.setCustomer(customer);
            accountService.saveNewAccount(account);
    }
    @Override
    public void deleteCustomer(long id) {
        accountService.deleteAccount(id);
        customerRepository.updateByStatus(id);
    }

    @Override
    public Page<Customer> findCustomerByName(String name, Pageable pageable) {
        return customerRepository.findByName(name, pageable);
    }

    @Override
    public Specification<Customer> getFilter(FilterCustomer filterCustomer) {
        List<CustomerSpecifications> specs = new ArrayList<>();
        Specification<Customer> spec;
        if(filterCustomer.getName() != null) {
            if (!filterCustomer.getName().equals(""))
                specs.add(new CustomerSpecifications(new SearchCriteria("name", "name", filterCustomer.getName())));
            else
                filterCustomer.setName(null);
        }
        if(filterCustomer.getCustomerType() != null) {
            if (!filterCustomer.getCustomerType().equals(""))
                specs.add(new CustomerSpecifications(new SearchCriteria("name", "type", filterCustomer.getCustomerType())));
            else
                filterCustomer.setCustomerType(null);
        }
        if(filterCustomer.getFrom() != null && filterCustomer.getTo() != null) {
            if (!filterCustomer.getFrom().equals("") && !filterCustomer.getTo().equals(""))
                specs.add(new CustomerSpecifications(new SearchCriteria("birthday", "date", filterCustomer.getFrom(), filterCustomer.getTo())));
            else {
                filterCustomer.setFrom(null);
                filterCustomer.setTo(null);
            }
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
        Pageable pageable = PageRequest.of(page - 1, 2);
        return customerRepository.findAll(spec, pageable);
    }
}
