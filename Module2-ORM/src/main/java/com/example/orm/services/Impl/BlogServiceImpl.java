package com.example.orm.services.Impl;

import com.example.orm.services.BlogService;
import com.example.orm.services.filters.BlogSpecification;
import com.example.orm.dtos.FilterBlog;
import com.example.orm.services.filters.SearchCriteria;
import com.example.orm.models.Blog;
import com.example.orm.repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogRepository blogRepository;

    @Override
    public Blog findBlogById(long id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Blog> findAllBlogs(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public void updateBlog(Blog blog) {
        if(blog != null)
            blogRepository.save(blog);
    }

    @Override
    public void saveBlog(Blog blog) {
        blog.setStatus(true);
        blog.setDateCreated(LocalDateTime.now());
        blogRepository.save(blog);
    }

    @Override
    public void deleteBlog(long id) {

        blogRepository.updateByIdAndStatus(id, false);
    }

    @Override
    public Page<Blog> findBlogByAuthor(String author, Pageable pageable) {
        return blogRepository.findByAuthorStartingWith(author, pageable);
    }

    @Override
    public Page<Blog> findBlogByCriteria(Specification<Blog> spec, Pageable pageable) {
        return blogRepository.findAll(spec, pageable);
    }

    @Override
    public Specification<Blog> getFilter(FilterBlog filterBlog) {
        List<BlogSpecification> specs = new ArrayList<>();
        Specification<Blog> spec;
        if(filterBlog.getAuthor() != null) {
            if (!filterBlog.getAuthor().equals(""))
                specs.add(new BlogSpecification(new SearchCriteria("author", "=", filterBlog.getAuthor())));
            else
                filterBlog.setAuthor(null);
        }
        if(filterBlog.getTitle() != null) {
            if (!filterBlog.getTitle().equals(""))
                specs.add(new BlogSpecification(new SearchCriteria("title", "=", filterBlog.getTitle())));
            else
                filterBlog.setTitle(null);
        }

        if (specs.size() != 0) {
            spec = Specification.where(specs.get(0));
            for (int i = 1; i < specs.size(); i++) {
                spec = spec.and(specs.get(i));
            }
            return spec;
        }
        return null;
    }
}
