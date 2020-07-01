package com.web.furama.controllers;

import com.web.furama.dtos.AccountRegister;
import com.web.furama.dtos.CustomerDto;
import com.web.furama.services.AccountService;
import com.web.furama.services.CustomerService;
import com.web.furama.services.impl.AccountServiceImpl;
import com.web.furama.services.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("account")
public class AccountController {

    @Autowired
    AccountServiceImpl accountService;

    @Autowired
    AccountRegister accountRegister1;

    @Autowired
    CustomerServiceImpl customerService;

    @GetMapping("/register")
    public ModelAndView showRegisterForm() {
        return new ModelAndView("accountTemplates/register", "register", new AccountRegister());
    }

    @PostMapping("/save")
    public String saveAccount(@Validated @ModelAttribute(name = "register") AccountRegister accountRegister, BindingResult bindingResult) {
        accountRegister1.validate(accountRegister, bindingResult);
        if (bindingResult.hasErrors()) {
            return "accountTemplates/register";
        }
        customerService.register(accountRegister, null);
        return "accountTemplates/register";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "accountTemplates/login";
//          return "redirect:/account/login?logout";
    }

    @GetMapping("/login")
    public ModelAndView showSignInForm() {
        return new ModelAndView("accountTemplates/login");
    }
}

