package com.web.furama.controllers;

import com.web.furama.models.Customer;
import com.web.furama.models.Facility;
import com.web.furama.models.FacilityType;
import com.web.furama.services.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
//@RequestMapping("facility")
public class FacilityController {

    @Autowired
    FacilityService facilityService;


    @ModelAttribute("facilityTypes")
    public List<FacilityType> getFacilityType() {
        return facilityService.getAllFacilityType();
    }


    @GetMapping({"facility/create", "admin/facilitycreate"})
    public ModelAndView showForm() {
        return new ModelAndView("facilityTemplates/create1", "facility", new Facility());
    }

    @PostMapping("admin/savefacility")
    public String addFacility(@Validated @ModelAttribute("facility") Facility facility, BindingResult bindingResult, Model model) {
       if(!bindingResult.hasErrors()) {
           model.addAttribute("message", true);
           facilityService.addNewFacility(facility);
       }
       return "facilityTemplates/create1";
    }
    @GetMapping({"facility/edit/{id}"})
    public ModelAndView showUpdateForm(@PathVariable long id) {
        return new ModelAndView("facilityTemplates/edit", "facility", facilityService.getFacilityById(id));
    }
    @PostMapping("facility/edit")
    public String editFacility(@Valid @ModelAttribute Facility facility, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            facilityService.updateFacility(facility);
            model.addAttribute("message", true);
        }
        return "facilityTemplates/edit";
    }
    @GetMapping("facility/delete/{id}")
    public String showDeleteForm(@PathVariable long id, RedirectAttributes redirectAttributes) {
        facilityService.delFacility(id);
        redirectAttributes.addFlashAttribute("message", true);
        return "redirect:/admin/facility";
    }
}
