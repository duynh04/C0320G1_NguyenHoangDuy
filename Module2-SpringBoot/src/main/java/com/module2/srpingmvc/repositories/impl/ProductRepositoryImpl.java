package com.module2.srpingmvc.repositories.impl;

import com.module2.srpingmvc.models.Product;
import com.module2.srpingmvc.repositories.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private static final Map<Long, Product> list;
    private static long index = 0;
    static {
        list = new HashMap<>();
        list.put(++index, new Product(index, "Iphone X", 999.00, "Apple"));
        list.put(++index, new Product(index, "Iphone 11", 1299.00, "Apple"));
        list.put(++index, new Product(index, "Iphone SE 2020", 699.00, "Apple"));
        list.put(++index, new Product(index, "Iphone 11 Pro", 1499.00, "Apple"));
    }
    @Override
    public void add(Product product) {
        product.setId(++index);
        list.put(index, product);
    }

    @Override
    public void update(long id, Product product) {
        list.put(id, product);
    }

    @Override
    public void deleteById(long id) {
        list.remove(id);
    }

    @Override
    public Product getById(long id) {
        return list.get(id);
    }

    @Override
    public List<Product> getAll() {
        return new ArrayList<>(list.values());
    }
}
