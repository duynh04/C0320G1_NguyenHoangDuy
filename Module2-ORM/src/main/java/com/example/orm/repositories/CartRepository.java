package com.example.orm.repositories;


import com.example.orm.models.Product;

import java.util.Map;

public interface CartRepository {
    Map<Integer, Product> findAll();
    void addToCart(Integer number,Product product);
}
