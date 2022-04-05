package pl.czarek.adminpanel.builder;

import pl.czarek.adminpanel.obj.orderOptions.Order;
import pl.czarek.adminpanel.obj.productOptions.Product;
import pl.czarek.adminpanel.obj.productOrderOptions.ProductOrder;

import java.sql.Date;

public class ProductOrderBuilder {

    private final ProductOrder productOrder;

    public ProductOrderBuilder(){
        this.productOrder = new ProductOrder();
    }

    public ProductOrderBuilder(int id){
        this.productOrder = new ProductOrder(id);
    }

    public ProductOrderBuilder setProduct(Product product){
        this.productOrder.setProduct(product);
        return this;
    }

    public ProductOrderBuilder setOrder(Order order){
        this.productOrder.setOrder(order);
        return this;
    }

    public ProductOrderBuilder setQuantity(int quantity){
        this.productOrder.setQuantity(quantity);
        return this;
    }

    public ProductOrderBuilder setPrice(float price){
        this.productOrder.setPrice(price);
        return this;
    }

    public ProductOrderBuilder setDate(Date date){
        this.productOrder.setDate(date);
        return this;
    }

    public ProductOrder getProductOrder(){
        return this.productOrder;
    }

}
