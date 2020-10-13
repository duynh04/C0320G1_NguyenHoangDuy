package com.web.furama.controllers;

import com.web.furama.models.Authority;
import com.web.furama.services.PaymentService;
import com.web.furama.services.restapi.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@Controller
public class HomeController {

    @Autowired
    private WeatherService weatherService;

    @Qualifier("paypal")
    @Autowired
    private PaymentService paypalService;

    @Qualifier("visa")
    @Autowired
    private PaymentService visalService;

    @ModelAttribute("visaToken")
    public String getVisaToken() {
        return visalService.getToken();
    }
    @ModelAttribute("paypalToken")
    public String getPaypalToken() {
        return paypalService.getToken();
    }

    @ModelAttribute("weather")
    public String getWeather() {
        return weatherService.getTemperature();
    }

    @GetMapping("")
    public String getHome() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        for(GrantedAuthority role: auth.getAuthorities()) {
            if (role.getAuthority().equals("ROLE_ADMIN"))
                return "adminTemplates/home";
            else
                return "index";
        }
        return "index";
    }

    @GetMapping("/contact")
    public String getContact() {
        return "contact";
    }
}
