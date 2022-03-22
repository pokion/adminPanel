package pl.czarek.adminpanel.builder;

import pl.czarek.adminpanel.obj.orderOptions.Order;

import java.sql.Date;

public class OrderBuilder {

    private final Order order;

    public OrderBuilder(){
        this.order = new Order();
    }

    public OrderBuilder(int id){
        this.order = new Order(id);
    }

    public OrderBuilder setUserID(int userID){
        this.order.setUserID(userID);
        return this;
    }

    public OrderBuilder setStatus(String status){
        this.order.setStatus(status);
        return this;
    }

    public OrderBuilder setDate(Date date){
        this.order.setDate(date);
        return this;
    }

    public Order getOrder(){
        return this.order;
    }
}
