package com.web.furama.services.impl;

import com.web.furama.dtos.AccountRegister;
import com.web.furama.models.Account;
import com.web.furama.models.Authority;
import com.web.furama.repositories.AccountRepository;
import com.web.furama.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;


    @Override
    public List<Account> getAllAccount() {
        return accountRepository.findAll();
    }

    @Override
    public Account getAccountByUserName(String userName) {
        return accountRepository.getAccountByUserName(userName);
    }

    @Override
    public void saveNewAccount(Account account) {
        account.setAuthority(new Authority(1));
        account.setStatus(true);
        accountRepository.save(account);
    }

    @Override
    public void deleteAccount(long id) {
//        accountRepository.
    }

    @Override
    public void updateAccount(long id) {

    }
}
