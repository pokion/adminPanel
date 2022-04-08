package pl.czarek.adminpanel.builder;

import pl.czarek.adminpanel.obj.cart.Cart;
import pl.czarek.adminpanel.obj.orderOptions.Order;
import pl.czarek.adminpanel.obj.productOptions.Product;
import pl.czarek.adminpanel.obj.productOrderOptions.ProductOrder;

public class CartBuilder {

    private final Cart cart;

    public CartBuilder(){
        this.cart = new Cart();
    }

    public CartBuilder setProductOrder(ProductOrder productOrder){
        this.cart.setProductOrder(productOrder);
        return this;
    }

    public CartBuilder setOrder(Order order){
        this.cart.setOrder(order);
        return this;
    }

    public CartBuilder setPath(String path){
        this.cart.setPath(path);
        return this;
    }

    public Cart getCart(){
        return this.cart;
    }
}
