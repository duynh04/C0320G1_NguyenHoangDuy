package com.example.orm.services;

import com.example.orm.dtos.FilterBlog;
import com.example.orm.models.Blog;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface BlogService {

    Blog findBlogById(long id);
    Page<Blog> findAllBlogs(Pageable pageable);

    void updateBlog(Blog blog);

    void saveBlog(Blog blog);

    void deleteBlog(long id);

    Page<Blog> findBlogByAuthor(String author, Pageable pageable);

    Page<Blog> findBlogByCriteria(Specification<Blog> spec, Pageable pageable);

    Specification<Blog> getFilter(FilterBlog filterBlog);
}
