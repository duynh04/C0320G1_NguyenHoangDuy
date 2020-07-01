package com.web.furama.controllers;

import com.web.furama.dtos.AccountRegister;
import com.web.furama.dtos.CustomerDto;
import com.web.furama.models.Account;
import com.web.furama.models.Customer;
import com.web.furama.models.CustomerType;
import com.web.furama.searches.FilterCustomer;
import com.web.furama.services.AccountService;
import com.web.furama.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
//@RequestMapping("")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    AccountService accountService;

    @GetMapping("customers/view")
    public ModelAndView getInformation(Principal principal) {
        Account account = accountService.getAccountByUserName(principal.getName());
        ModelAndView modelAndView = new ModelAndView("customerTemplates/edit");
        modelAndView.addObject("customer", account.getCustomer());
        return modelAndView;
    }

    @PostMapping("customers/save")
    public String saveCustomer(@Valid @ModelAttribute("customer") CustomerDto customerDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "customerTemplates/create";
        }
//        model.addAttribute("message", true);
//        customerService.saveCustomer(customer);
        return "customerTemplates/create";
    }
    @GetMapping({"customers/edit/{id}"})
    public ModelAndView showUpdateForm(@PathVariable long id) {
        return new ModelAndView("customerTemplates/edit", "customer", customerService.findCustomerById(id));
    }
    @PostMapping("customers/edit")
    public String editCustomer(@Valid @ModelAttribute Customer customer, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            customerService.updateCustomer(customer);
            model.addAttribute("message", true);
        }
        return "customerTemplates/edit";
    }
    @GetMapping("customers/delete/{id}")
    public String showDeleteForm(@PathVariable long id, RedirectAttributes redirectAttributes) {
        customerService.deleteCustomer(id);
        redirectAttributes.addFlashAttribute("message", true);
        return "redirect:/admin/customer";
    }


    @ModelAttribute("customerTypes")
    public List<CustomerType> getCustomerTypes() {
        return  customerService.getCustomerTypes();
    }
}
