package com.web.furama.repositories;

import com.web.furama.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Account getAccountByUserName(String userName);
}
