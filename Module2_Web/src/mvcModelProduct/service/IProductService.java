package mvcModelProduct.service;

import java.util.List;

public interface IProductService<T> {
    List<T> findAll();
    int getIndex();
    void addProduct(T product);
    void editProduct(int id, T product);
    void deleteProduct(int id);
    T findById(int id);
    List<T> findByName(String name);
}
