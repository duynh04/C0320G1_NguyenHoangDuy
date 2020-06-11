package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class HomeController {
    private static Pattern pattern;

    private Matcher matcher; // Khai báo Regex
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";



    public HomeController() {

        pattern = Pattern.compile(EMAIL_REGEX);

    }

    @RequestMapping(value = "/", method = RequestMethod.GET)

    public String home() {
        return "home";
    }



    @PostMapping(value = "/validate")

    public ModelAndView user(@RequestParam("email") String email) {

        boolean isValid = this.validate(email);

        if (!isValid) {
            return new ModelAndView("home", "message", "Email is invalid");
        }
        return new ModelAndView("success", "email", email);
    }

    private boolean validate(String regex) {

        matcher = pattern.matcher(regex);

        return matcher.matches();

    }
}
