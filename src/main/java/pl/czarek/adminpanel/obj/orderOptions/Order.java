package pl.czarek.adminpanel.obj.orderOptions;

import pl.czarek.adminpanel.obj.userOptions.User;

import java.sql.Date;

public class Order {
    private int id;
    private User user;
    private String status;
    private Date date;

    public Order(){}

    public Order(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public User getUser(){
        return user;
    }

    public Date getDate(){
        return date;
    }

    public String getStatus(){
        return status;
    }

    public void setUser(User user){
        this.user = user;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public void setDate(Date date){
        this.date = date;
    }
}
