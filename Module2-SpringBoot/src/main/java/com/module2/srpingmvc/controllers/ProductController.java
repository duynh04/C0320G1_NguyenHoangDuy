package com.module2.srpingmvc.controllers;

import com.module2.srpingmvc.models.Product;
import com.module2.srpingmvc.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public ModelAndView getHome() {
        return new ModelAndView("home", "products", productService.getAllProduct());
    }

    @GetMapping("/create")
    public ModelAndView getCreateForm() {
        return new ModelAndView("create-form", "product", new Product());
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.addProduct(product);
        redirectAttributes.addFlashAttribute("success", "Product was created successfully!");
        return "redirect:";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView getEditForm(@PathVariable long id) {
        return new ModelAndView("edit-form", "product", productService.getProductById(id));
    }

    @PostMapping("/update")
    public String updateProduct(@RequestParam long id , @ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.updateProduct(id, product);
        redirectAttributes.addFlashAttribute("success", "Product was updated successfully!");
        return "redirect:";
    }

    @GetMapping("delete/{id}")
    public ModelAndView getDelteForm(@PathVariable long id) {
        return new ModelAndView("delete-form", "product", productService.getProductById(id));
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam long id, RedirectAttributes redirectAttributes) {
        productService.deleteProductById(id);
        redirectAttributes.addFlashAttribute("success", "Product was deleted successfully!");
        return "redirect:";
    }

    @GetMapping("view/{id}")
    public ModelAndView getViewForm(@PathVariable long id) {
        return new ModelAndView("view-form", "product", productService.getProductById(id));
    }
}
