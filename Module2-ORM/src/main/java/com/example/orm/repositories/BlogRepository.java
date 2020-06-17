package com.example.orm.repositories;

import com.example.orm.models.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;

import javax.transaction.Transactional;


public interface BlogRepository extends JpaRepository<Blog, Long>, JpaSpecificationExecutor<Blog> {

    @Transactional
    @Modifying
    @Query("update Blog b set b.status = :status where b.id = :id")
    void updateByIdAndStatus(long id, Boolean status);


    Page<Blog> findByAuthorStartingWith(String author, Pageable pageable);

    //Page<Blog> findAll(Specification<Blog> spec, Pageable pageable);
}
