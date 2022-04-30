package ru.first.product;

import java.util.HashMap;
import java.util.Map;

public class ProductService {

    private  Map<String, Product> products = new HashMap<>();

    public ProductService() {
        products.put("Kefir", new Product("Kefir", 100, "DiaryProduct"));
        products.put("Milk", new Product("Milk", 200, "DiaryProduct"));
        products.put("Yougrt", new Product("Yougrt", 30, "DiaryProduct"));
        products.put("Banan", new Product("Banan", 90, "Fruits"));
        products.put("Apple", new Product("Apple", 100, "Fruits"));
    }


    public  synchronized Map<String, Product> getAll() {
        return products;
    }

    public synchronized  Product get(String name) {
        return null;
    }


    public synchronized Map<String, Product> getByNameAndCategory(String name, String category) {
        return null;
    }


    public synchronized boolean delete(String name) {
        return false;
    }


    public  synchronized void add(Product product) {
        products.put(product.getName(), product);
    }

}
