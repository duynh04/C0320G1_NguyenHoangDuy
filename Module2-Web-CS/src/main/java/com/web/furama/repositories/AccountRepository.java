package com.web.furama.repositories;

import com.web.furama.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Account getAccountByUserName(String userName);

    @Transactional
    @Modifying
    @Query(value="update Account a set a.status = false where a.customer.id = ?1")
    void updateAccount(long id);
}
