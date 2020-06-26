package com.example.orm.controllers;

import com.example.orm.dtos.ContractDto;
import com.example.orm.models.AttachService;
import com.example.orm.models.Contract;
import com.example.orm.repositories.AttachServiceRepository;
import com.example.orm.repositories.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("contracts")
public class ContractController {

    @Autowired
    private ContractRepository contractRepository;
    @Autowired
    private AttachServiceRepository attachServiceRepository;

    @ModelAttribute("attachs")
    private List<AttachService> getAttach() {
        return attachServiceRepository.findAll();
    }
    @GetMapping("")
    public ModelAndView showCreate() {
        return new ModelAndView("create-form", "contract", new Contract());
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute("attachs") List<AttachService> attachServices, @ModelAttribute ContractDto contractDto) {
        Contract contract = new Contract();
        contract.setName(contractDto.getName());
        for(int item : contractDto.getAttachServices()) {
            contract.addAttachService(attachServices.get(item));
        }
        contractRepository.save(contract);
        return new ModelAndView("create-form");
    }
}
