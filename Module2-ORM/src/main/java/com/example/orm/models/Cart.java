package com.example.orm.models;

import javax.persistence.*;
import java.util.*;

public class Cart {

    @Column(name = "cart_quantity")
    private int quantity;

    private final List<Product> product;

    public Cart() {
        this.product = new ArrayList<>();
    }

    public Cart(int quantity, List<Product> product) {
        this.quantity = quantity;
        this.product = product;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void addProduct(Product product) {
        this.product.add(product);
    }
}
