package com.example.exam.repositories;

import com.web.furama.models.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerTypeRepository extends JpaRepository<CustomerType, Long> {
}
