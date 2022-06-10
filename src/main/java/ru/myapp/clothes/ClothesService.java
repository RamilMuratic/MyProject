package ru.myapp.clothes;

import java.util.HashMap;
import java.util.Map;

public class ClothesService {

    private static Map<String, Clothes> clothes = new HashMap<>();

    static  {
        clothes.put("cap", new Clothes("cap", 100.0, "headdress", "M", "Black", "China"));
        clothes.put("polo", new Clothes("polo", 100.0, "headdress", "XL", "Black", "China"));
        clothes.put("t-shirt", new Clothes("t-shirt", 255.1, "t-shirt", "L", "Black", "China"));

    }

    public static synchronized Map<String, Clothes> getAll() {
        return clothes;
    }

    public  synchronized void add(Clothes clothes) {
        this.clothes.put(clothes.getName(), clothes);
    }

}
