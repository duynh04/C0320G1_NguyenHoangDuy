package com.module2.srpingmvc.services;

import com.module2.srpingmvc.models.Product;

import java.util.List;

public interface ProductService {
    void addProduct(Product product);
    void updateProduct(long id, Product product);
    void deleteProductById(long id);
    Product getProductById(long id);
    List<Product> getAllProduct();
}
