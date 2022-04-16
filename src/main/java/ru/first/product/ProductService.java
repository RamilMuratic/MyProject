package ru.first.product;

import java.util.HashMap;
import java.util.Map;

public class ProductService {

    private static Map<String, Product> products = new HashMap<>();

   static  {
        products.put("Kefir", new Product("Kefir", 100, "DiaryProduct"));
        products.put("Milk", new Product("Milk", 200, "DiaryProduct"));
        products.put("Yougrt", new Product("Yougrt", 30, "DiaryProduct"));
        products.put("Banan", new Product("Banan", 90, "Fruits"));
        products.put("Apple", new Product("Apple", 100, "Fruits"));
    }


    public static synchronized Map<String, Product> getAll() {

        return products;

    }


    public static Product get(String name) {

        return null;
    }


    public static Map<String, Product> getByNameAndCategory(String name, String category) {
        return null;
    }


    public static boolean delete(String name) {
        return false;
    }


    public static synchronized void add(Product product) {

        products.put(product.getName(), product);

    }

}
