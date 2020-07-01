package com.web.furama.services.impl;

import com.web.furama.models.Account;
import com.web.furama.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.SimpleFormatter;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    AccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountService.getAccountByUserName(username);
        if (account == null) {
            throw new UsernameNotFoundException("No user founded!");
        }
        return new CustomUserDetails(account);
    }

}
