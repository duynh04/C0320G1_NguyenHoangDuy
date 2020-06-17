package com.module2.srpingmvc.models;

public class Product {
    private long Id;
    private String  name;
    private Double price;
    private String Manufacturer;

    public Product() {
    }

    public Product(String name, Double price, String manufacturer) {
        this.name = name;
        this.price = price;
        Manufacturer = manufacturer;
    }

    public Product(long id, String name, Double price, String manufacturer) {
        Id = id;
        this.name = name;
        this.price = price;
        Manufacturer = manufacturer;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getManufacturer() {
        return Manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        Manufacturer = manufacturer;
    }
}
