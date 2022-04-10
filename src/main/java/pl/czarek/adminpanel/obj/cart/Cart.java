package pl.czarek.adminpanel.obj.cart;

import pl.czarek.adminpanel.obj.orderOptions.Order;
import pl.czarek.adminpanel.obj.productOrderOptions.ProductOrder;

public class Cart {
    private int id;
    private ProductOrder productOrder;
    private Order order;
    private String path;

    public Cart(){}

    public Cart(int id){
        this.id = id;
    }

    public String getPath(){
        return path;
    }

    public ProductOrder getProductOrder(){
        return productOrder;
    }

    public Order getOrder(){
        return order;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setProductOrder(ProductOrder productOrder){
        this.productOrder = productOrder;
    }

    public void setOrder(Order order){
        this.order = order;
    }

    public void setPath(String path){
        this.path = path;
    }
}
