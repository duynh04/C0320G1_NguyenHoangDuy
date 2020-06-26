package com.web.furama.repositories;

import com.web.furama.models.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Page<Customer> findByName(String name, Pageable pageable);

    Customer getCustomerByEmail(String email);

    @Transactional
    @Modifying
    @Query(value="update Customer c set c.status = false where c.id = :id")
    void updateByStatus(long id);
}
