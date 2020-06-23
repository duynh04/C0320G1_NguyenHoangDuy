package com.example.orm.controllers;

import com.example.orm.models.Cart;
import com.example.orm.models.Product;
import com.example.orm.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes(names = "cart")
@RequestMapping("products")
public class ProductController {


    @Autowired
    private ProductService productService;

    @ModelAttribute(name = "cart")
    public Cart getCart() {
        return new Cart();
    }

    @GetMapping("")
    public ModelAndView getHome(@CookieValue(value = "user", defaultValue = "") String user, @RequestParam(name = "page", required = false, defaultValue = "1") int page,
                                HttpServletRequest request, HttpServletResponse response) {
        boolean check = false;
        ModelAndView modelAndView = new ModelAndView("productTemplate/home");
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie: cookies) {
            if(cookie.getValue().equals(user)) {
                modelAndView.addObject("user", cookie);
                check = true;
                break;
            }
        }
        if (!check)
            modelAndView.addObject("user", null);
        Page<Product> pageProduct = productService.findAllProducts(page);
        modelAndView.addObject("products", pageProduct);
        return modelAndView;
    }

    @GetMapping("/cart")
    public String showCart() {
        return "productTemplate/cart";
    }
    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable(name = "id", required = false) long id, @ModelAttribute(name = "cart") Cart cart, RedirectAttributes redirectAttributes) {
        Product product = productService.findProductById(id);
        cart.addProduct(product);
        redirectAttributes.addFlashAttribute("success", "Add successfully!!");
        return "redirect:/products";
    }

    @GetMapping("/login")
    public String showLogin() {
        return "productTemplate/login";
    }
    @GetMapping("/logout")
    public String doLogout(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = new Cookie("user", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:/products";
    }
    @PostMapping("/login")
    public String doLogin(@RequestParam String email, @RequestParam String password,
                        HttpServletRequest request, HttpServletResponse response, Model model) {
        if (email.equals("admin@gmail.com") && password.equals("123456")) {
            Cookie cookie = new Cookie("user", "admin");
            cookie.setMaxAge(24*60*60);
            response.addCookie(cookie);
            return "redirect:/products";
        } else {
            model.addAttribute("message", "Login Fail");
            return "productTemplate/login";
        }
    }
}
