package com.example.orm.repositories;

import com.example.orm.models.Customer;
import com.example.orm.models.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {
    Page<Customer> findByFirstName(String firstName, Pageable pageable);

    @Transactional
    @Modifying
    @Query(value="update Customer c set c.status = false where c.id = :id")
    void updateByStatus(long id);

    Page<Customer> findCustomerByProvince(Province province, Pageable pageable);
}
