package pl.czarek.adminpanel.builder;

import pl.czarek.adminpanel.obj.cartOption.Cart;

public class CartBuilder {

    private final Cart cart;

    public CartBuilder(int id){
        this.cart = new Cart(id);
    }

    public CartBuilder setListProduct(String listProduct){
        this.cart.setListProduct(listProduct);
        return  this;
    }

    public CartBuilder setUserID(int id){
        this.cart.setUserID(id);
        return this;
    }

    public CartBuilder setStatus(String status){
        this.cart.setStatus(status);
        return this;
    }

    public Cart getCart(){
        return this.cart;
    }

}
