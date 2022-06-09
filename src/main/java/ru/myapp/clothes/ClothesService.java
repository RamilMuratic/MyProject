package ru.myapp.clothes;

import java.util.HashMap;
import java.util.Map;

public class ClothesService {

    private  Map<String, Clothes> clothes = new HashMap<>();

    public ClothesService() {
        clothes.put("cap", new Clothes("cap", 100.0, "headdress", "M", "Black", "China"));
        clothes.put("cap", new Clothes("cap", 100.0, "headdress", "L", "Black", "China"));
        clothes.put("cap", new Clothes("cap", 100.0, "headdress", "S", "Black", "China"));
        clothes.put("cap", new Clothes("cap", 100.0, "headdress", "XL", "Black", "China"));

        clothes.put("t-shirt", new Clothes("t-shirt", 255.1, "t-shirt", "L", "Black", "China"));

    }


    public synchronized Map<String, Clothes> getAll() {
        return clothes;
    }

    public synchronized Clothes get(String name) {
        return clothes.get(name);
    }


    public synchronized Map<String, Clothes> getByNameAndCategory(String name, String category) {
        return null;
    }


    public synchronized boolean delete(String name) {
        return false;
    }


    public  synchronized void add(Clothes clothes) {
        this.clothes.put(clothes.getName(), clothes);
    }

}
