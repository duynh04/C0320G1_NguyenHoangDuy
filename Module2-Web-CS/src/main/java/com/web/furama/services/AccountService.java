package com.web.furama.services;

import com.web.furama.models.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAllAccount();
    Account getAccountByUserName(String userName);
    void saveNewAccount(Account account);
    void deleteAccount(long id);
    void updateAccount(long id);
}
