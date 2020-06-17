package com.module2.srpingmvc.services.impl;

import com.module2.srpingmvc.models.Product;
import com.module2.srpingmvc.repositories.ProductRepository;
import com.module2.srpingmvc.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void addProduct(Product product) {
        productRepository.add(product);
    }

    @Override
    public void updateProduct(long id, Product product) {
        productRepository.update(id, product);
    }

    @Override
    public void deleteProductById(long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product getProductById(long id) {
        return productRepository.getById(id);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.getAll();
    }
}
