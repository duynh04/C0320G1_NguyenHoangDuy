package com.example.orm.services.Impl;

import com.example.orm.models.Product;
import com.example.orm.repositories.ProductRepository;
import com.example.orm.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Page<Product> findAllProducts(int page) {
        Pageable pageable = PageRequest.of(page - 1, 3);
        return productRepository.findAll(pageable);
    }

    @Override
    public Product findProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
