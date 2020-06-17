package com.example.orm.Services;

import com.example.orm.Services.filter.BlogSpecifications;
import com.example.orm.Services.filter.FilterBlog;
import com.example.orm.models.Blog;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.util.Streamable;
import org.springframework.lang.Nullable;

import java.util.List;

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
