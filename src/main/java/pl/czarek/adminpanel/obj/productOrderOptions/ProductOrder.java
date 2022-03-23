package pl.czarek.adminpanel.obj.productOrderOptions;

import java.sql.Date;

public class ProductOrder {
    private int id;
    private int productID;
    private int orderID;
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

    public int getProductID(){
        return productID;
    }

    public int getOrderID(){
        return orderID;
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

    public void setProductID(int productID){
        this.productID = productID;
    }

    public void setOrderID(int orderID){
        this.orderID = orderID;
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
