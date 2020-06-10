package mvcModelProduct.service;

import mvcModelProduct.models.Product;

import java.util.*;

public class ProductServiceImpl implements IProductService<Product> {
    private final static Map<Integer, Product> productList;
    private static int index = 0;
    static {
        productList = new HashMap<>();
        productList.put(++index, new Product(1, "Iphone 11", 999.0));
        productList.put(++index, new Product(2, "Iphone X", 800.0));
        productList.put(++index, new Product(3, "Iphone 11 Pro", 1199.0));
        productList.put(++index, new Product(4, "Iphone 8", 799.0));
        productList.put(++index, new Product(5, "Iphone 11", 699.0));
    }
    public ProductServiceImpl() { }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productList.values());
    }

    @Override
    public int getIndex(){
        return index;
    }
    @Override
    public void addProduct(Product product) {
        productList.put(++index, product);
    }

    @Override
    public void editProduct(int id, Product product) {
        productList.put(id, product);
    }

    @Override
    public void deleteProduct(int id) {
        productList.remove(id);
    }

    @Override
    public Product findById(int id) {
        return productList.get(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> products = new ArrayList<>();
        Set<Integer> productSet = productList.keySet();
        for (Integer index: productSet) {
            Product product = productList.get(index);
            if(product.getName().equals(name)) {
                products.add(product);
            }
        }
        return products;
    }
}
