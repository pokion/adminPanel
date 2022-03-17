package pl.czarek.adminpanel.service;

import pl.czarek.adminpanel.obj.cartOption.Cart;

import java.util.*;

public class CartService {

    private final Map<Integer, Cart> carts;

    public CartService(){
        this.carts = new HashMap<>();
    }

    public void createCart(Cart cart){
        this.carts.put(cart.getId(), cart);
    }

    public Optional<Cart> findCart(int id){
        return Optional.of(this.carts.get(id));
    }

    public void updateCart(int id, String status, int userID, String  listProduct){
        this.carts.get(id).setStatus(status);
        this.carts.get(id).setUserID(userID);
        this.carts.get(id).setListProduct(listProduct);
    }

    public void removeCart(int id){
        this.carts.remove(id);
    }

}
