package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {

    @RequestMapping("")
    public String display () {
        return "calc";
    }

    @PostMapping(params = "add")
    public String add(@RequestParam("num1") double n1, @RequestParam("num2") double n2, Model model) {
        model.addAttribute("result", n1 + n2);
        model.addAttribute("num1", n1);
        model.addAttribute("num2", n2);
        return "calc";
    }

    @PostMapping(params = "sub")
    public String subtract(@RequestParam("num1") double n1, @RequestParam("num2") double n2, Model model) {
        model.addAttribute("result", n1 - n2);
        model.addAttribute("num1", n1);
        model.addAttribute("num2", n2);
        return "calc";
    }

    @PostMapping(params = "mul")
    public String multiply(@RequestParam("num1") double n1, @RequestParam("num2") double n2, Model model) {
        model.addAttribute("result", n1 * n2);
        model.addAttribute("num1", n1);
        model.addAttribute("num2", n2);
        return "calc";
    }

    @PostMapping(params = "div")
    public String divde(@RequestParam("num1") double n1, @RequestParam("num2") double n2, Model model) {
        model.addAttribute("result", n1 / n2);
        model.addAttribute("num1", n1);
        model.addAttribute("num2", n2);
        return "calc";
    }
}
