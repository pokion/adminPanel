package pl.czarek.adminpanel.obj.productOrderOptions;

import pl.czarek.adminpanel.obj.orderOptions.Order;
import pl.czarek.adminpanel.obj.productOptions.Product;

import java.sql.Date;

public class ProductOrder {
    private int id;
    private Product product;
    private Order order;
    private int quantity;
    private float price;
    private Date date;

    public ProductOrder(){}

    public ProductOrder(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public Product getProduct(){
        return product;
    }

    public Order getOrder(){
        return order;
    }

    public int getQuantity(){
        return quantity;
    }

    public float getPrice(){
        return price;
    }

    public Date getDate(){
        return date;
    }

    public void setProduct(Product product){
        this.product = product;
    }

    public void setOrder(Order order){
        this.order = order;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public void setPrice(float price){
        this.price = price;
    }

    public void setDate(Date date){
        this.date = date;
    }
}
