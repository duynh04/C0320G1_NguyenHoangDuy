package com.web.furama.controllers;

import com.web.furama.models.AttachFacility;
import com.web.furama.models.Facility;
import com.web.furama.models.FacilityType;
import com.web.furama.services.AttachFacilityService;
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
@RequestMapping("attachFacility")
public class AttachFacilityController {


    @Autowired
    AttachFacilityService attachFacilityService;


    @GetMapping({"/create"})
    public ModelAndView showForm() {
        return new ModelAndView("attachFacilityTemplates/create", "attachFacility", new AttachFacility());
    }

    @PostMapping("/save")
    public String addAttachFacility(@Validated @ModelAttribute("attachFacility") AttachFacility attachFacility, BindingResult bindingResult, Model model) {
        if(!bindingResult.hasErrors()) {
            model.addAttribute("message", true);
            attachFacilityService.addNewAttachFacility(attachFacility);
        }
        return "attachFacilityTemplates/create";
    }
    @GetMapping({"/edit/{id}"})
    public ModelAndView showUpdateForm(@PathVariable long id) {
        return new ModelAndView("attachFacilityTemplates/edit", "attachFacility", attachFacilityService.findAttachFacilityById(id));
    }
    @PostMapping("/edit")
    public String editFacility(@Valid @ModelAttribute AttachFacility attachFacility, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            attachFacilityService.updateAttachFacility(attachFacility);
            model.addAttribute("message", true);
        }
        return "attachFacilityTemplates/edit";
    }
    @GetMapping("/delete/{id}")
    public String showDeleteForm(@PathVariable long id, RedirectAttributes redirectAttributes) {
        attachFacilityService.deleteAttachFacility(id);
        redirectAttributes.addFlashAttribute("message", true);
        return "redirect:/admin/attach";
    }
}
