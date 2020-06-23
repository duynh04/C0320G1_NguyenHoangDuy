package com.example.orm.services;


import com.example.orm.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    Page<Product> findAllProducts(int pageNumber);
    Product findProductById(Long id);
}
