package com.example.orm.controllers;

import com.example.orm.dtos.FilterProvince;
import com.example.orm.models.Customer;
import com.example.orm.models.Province;
import com.example.orm.services.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("provinces")
public class ProvinceController {

    @Autowired
    private ProvinceService provinceService;

    @GetMapping("")
    public ModelAndView getHome(@ModelAttribute FilterProvince filterProvince, @PageableDefault(value = 2) Pageable pageable) {
        Specification<Province> specs = provinceService.getFilter(filterProvince);
        ModelAndView modelAndView = new ModelAndView("provinceTemplate/home");
        if(specs != null) {
            modelAndView.addObject("provinces", provinceService.findProvinceByCriteria(specs, pageable));
        } else {
            Page<Province> pageProvince = provinceService.findAllProvinces(pageable);
            modelAndView.addObject("provinces", pageProvince);
        }
        modelAndView.addObject("filter", filterProvince);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        return new ModelAndView("provinceTemplate/create-form", "province", new Province());
    }

    @PostMapping("/save")
    public String saveProvince(@ModelAttribute Province province, RedirectAttributes redirectAttributes) {
        provinceService.saveProvince(province);
        redirectAttributes.addFlashAttribute("success", "Create new province successfully!");
        return "redirect:/provinces";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showUpdateForm(@PathVariable long id) {
        return new ModelAndView("provinceTemplate/edit-form", "province", provinceService.findProvinceById(id));
    }
    @PostMapping("/edit")
    public String editProvince(@ModelAttribute Province province, RedirectAttributes redirectAttributes) {
        provinceService.updateProvince(province);
        redirectAttributes.addFlashAttribute("success", "Update province successfully!");
        return "redirect:/provinces";
    }
    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable long id) {
        return new ModelAndView("provinceTemplate/delete-form", "province", provinceService.findProvinceById(id));
    }

    @PostMapping("/delete")
    public String deleteprovince(@RequestParam long id, RedirectAttributes redirectAttributes) {
        provinceService.deleteProvince(id);
        redirectAttributes.addFlashAttribute("success", "Delete successfully!");
        return "redirect:/provinces";
    }
}
