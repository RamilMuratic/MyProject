package ru.myapp.shopcart;

import ru.myapp.clothes.Clothes;
import java.util.List;

public class BasketService {

    public static void removeFromBasket(int id, List<Clothes> myShopCart) {
        if(myShopCart !=null) {
            myShopCart.remove(id);
        }
    }
}
