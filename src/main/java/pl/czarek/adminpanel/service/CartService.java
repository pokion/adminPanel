package pl.czarek.adminpanel.service;

import pl.czarek.adminpanel.obj.cartOption.Cart;
import pl.czarek.adminpanel.obj.categoryOptions.Category;

import java.util.*;

public class CartService {

    private final  DatabaseService databaseService;
    private final Map<Integer, Cart> carts;

    public CartService(DatabaseService databaseService){
        this.carts = new HashMap<>();
        this.databaseService = databaseService;
    }

    public void createCart(Cart cart){
        this.carts.put(cart.getId(), cart);
        this.databaseService.performDML(
                "INSERT INTO cart(userID) VALUE ('"+ cart.getUserID() +"')"
        );
    }

    public Optional<Cart> findCart(int id){
        return Optional.of(this.carts.get(id));
    }

    public void updateCart(Cart cart){
        if (this.carts.containsKey(cart.getId())){
            this.carts.replace(cart.getId(), cart);
        } else {
            throw new IllegalStateException("No cart under given ID");
        }
    }

    public void removeCart(int id){
        this.carts.remove(id);
    }

}
