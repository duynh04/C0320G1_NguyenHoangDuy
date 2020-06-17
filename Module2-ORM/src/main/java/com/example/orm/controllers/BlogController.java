package com.example.orm.controllers;

import com.example.orm.Services.BlogService;
import com.example.orm.Services.filter.BlogSpecifications;
import com.example.orm.Services.filter.FilterBlog;
import com.example.orm.Services.filter.SearchCriteria;
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

import javax.enterprise.inject.Model;
import java.util.List;

@Controller
@RequestMapping("blogs")
public class BlogController {

    @Autowired
    BlogService blogService;

    @GetMapping("")
    public ModelAndView getHome(@ModelAttribute FilterBlog filterBlog, @PageableDefault(value = 2) Pageable pageable) {
        Specification<Blog> specs = blogService.getFilter(filterBlog);
        ModelAndView modelAndView = new ModelAndView("home");
        if(specs != null) {
            modelAndView.addObject("blogs", blogService.findBlogByCriteria(specs, pageable.previousOrFirst()));
        } else {
            Page<Blog> pageBlog = blogService.findAllBlogs(pageable.previousOrFirst());
            modelAndView.addObject("blogs", pageBlog);
        }
        modelAndView.addObject("filter", filterBlog);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        return new ModelAndView("create-form", "blog", new Blog());
    }

    @PostMapping("/save")
    public String saveBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.saveBlog(blog);
        redirectAttributes.addFlashAttribute("success", "Create new blog successfully!");
        return "redirect:";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable long id) {
        return new ModelAndView("delete-form", "blog", blogService.findBlogById(id));
    }

    @PostMapping("/delete")
    public String deleteBlog(@RequestParam long id, RedirectAttributes redirectAttributes) {
        blogService.deleteBlog(id);
        redirectAttributes.addFlashAttribute("success", "Delete successfully!");
        return "redirect:";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showUpdateForm(@PathVariable long id) {
        return new ModelAndView("edit-form", "blog", blogService.findBlogById(id));
    }
    @PostMapping("/edit")
    public String editBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.updateBlog(blog);
        redirectAttributes.addFlashAttribute("success", "Update Blog successfully!");
        return "redirect:";
    }
}
