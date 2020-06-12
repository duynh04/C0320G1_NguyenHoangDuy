package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sandwich")
public class SandwichController {

    @GetMapping("/")
        public String display(Model model) {
            String[] spices = {"Lettuce", "Tomato", "Mustard", "Sprout"};
            model.addAttribute("spices", spices);
            model.addAttribute("SelectedSpice", new SpiceOfSandwich());
            return "displaySandwich";
    }
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute SpiceOfSandwich spice) {
        StringBuilder message = new StringBuilder();
        for (String item: spice.getSpice()) {
            message.append(item).append('-');
        }
        return new ModelAndView("displaySandwich", "message", message.toString());
    }
    static class SpiceOfSandwich {
        private String[] spice;

    public String[] getSpice() {
        return spice;
    }

    public void setSpice(String[] spice) {
        this.spice = spice;
    }
}
}
