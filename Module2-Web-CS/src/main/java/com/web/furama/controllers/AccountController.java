package com.web.furama.controllers;

import com.web.furama.dtos.AccountRegister;
import com.web.furama.models.Account;
import com.web.furama.services.AccountService;
import com.web.furama.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @Autowired
    CustomerService customerService;


    @GetMapping("/register")
    public ModelAndView showRegisterForm() {
        return new ModelAndView("accountTemplates/register", "register", new AccountRegister());
    }

    @PostMapping("/save")
    public String saveAccount(@Validated @ModelAttribute(name = "register") AccountRegister accountRegister, BindingResult bindingResult) {
        accountRegister.validate(accountRegister, bindingResult);
        if (bindingResult.hasErrors()) {
            return "accountTemplates/register";
        }
        customerService.register(accountRegister);
        return "accountTemplates/register";
    }

    @GetMapping("/signin")
    public ModelAndView showSignInForm() {
        return new ModelAndView("accountTemplates/signIn", "signin", new Account());
    }
}
