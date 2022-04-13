package pl.czarek.adminpanel.builder;

import pl.czarek.adminpanel.obj.orderOptions.Order;
import pl.czarek.adminpanel.obj.userOptions.User;

import java.sql.Date;

public class OrderBuilder {

    private final Order order;

    public OrderBuilder(){
        this.order = new Order();
    }

    public OrderBuilder(int id){
        this.order = new Order(id);
    }

    public OrderBuilder setUser(User user){
        this.order.setUser(user);
        return this;
    }

    public OrderBuilder setName(String name){
        this.order.setName(name);
        return this;
    }

    public OrderBuilder setUrsname(String ursname){
        this.order.setUrsname(ursname);
        return this;
    }

    public OrderBuilder setPhoneNumber(int phoneNumber){
        this.order.setPhoneNumber(phoneNumber);
        return this;
    }

    public OrderBuilder setEmail(String email){
        this.order.setEmail(email);
        return this;
    }

    public OrderBuilder setPostCode(String postCode){
        this.order.setPostCode(postCode);
        return this;
    }

    public  OrderBuilder setCity(String city){
        this.order.setCity(city);
        return this;
    }

    public OrderBuilder setStreet(String street){
        this.order.setStreet(street);
        return this;
    }

    public OrderBuilder setBuilding(int building){
        this.order.setBuilding(String.valueOf(building));
        return this;
    }

    public OrderBuilder setPaymentMethod(String paymentMethod){
        this.order.setPaymentMethod(paymentMethod);
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
