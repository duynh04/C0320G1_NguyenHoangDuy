package com.example.orm.controllers;

import com.example.orm.services.BlogService;
import com.example.orm.dtos.FilterBlog;
import com.example.orm.models.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("blogs")
public class BlogController {

    @Autowired
    BlogService blogService;

    @GetMapping("")
    public ModelAndView getHome(@ModelAttribute FilterBlog filterBlog, @PageableDefault(value = 2) Pageable pageable) {
        Specification<Blog> specs = blogService.getFilter(filterBlog);
        ModelAndView modelAndView = new ModelAndView("blogTemplate/home");
        if(specs != null) {
            modelAndView.addObject("blogs", blogService.findBlogByCriteria(specs, pageable));
        } else {
            Page<Blog> pageBlog = blogService.findAllBlogs(pageable);
            modelAndView.addObject("blogs", pageBlog);
        }
        modelAndView.addObject("filter", filterBlog);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        return new ModelAndView("blogTemplate/create-form", "blog", new Blog());
    }

    @PostMapping("/save")
    public String saveBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.saveBlog(blog);
        redirectAttributes.addFlashAttribute("success", "Create new blog successfully!");
        return "redirect:/blogs";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable long id) {
        return new ModelAndView("blogTemplate/delete-form", "blog", blogService.findBlogById(id));
    }

    @PostMapping("/delete")
    public String deleteBlog(@RequestParam long id, RedirectAttributes redirectAttributes) {
        blogService.deleteBlog(id);
        redirectAttributes.addFlashAttribute("success", "Delete successfully!");
        return "redirect:/blogs";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showUpdateForm(@PathVariable long id) {
        return new ModelAndView("blogTemplate/edit-form", "blog", blogService.findBlogById(id));
    }
    @PostMapping("/edit")
    public String editBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.updateBlog(blog);
        redirectAttributes.addFlashAttribute("success", "Update Blog successfully!");
        return "redirect:/blogs";
    }
}
