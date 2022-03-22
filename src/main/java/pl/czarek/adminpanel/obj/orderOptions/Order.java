package pl.czarek.adminpanel.obj.orderOptions;

import java.sql.Date;

public class Order {
    private int id;
    private int userID;
    private String status;
    private Date date;

    public Order(){}

    public Order(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public int getUserID(){
        return userID;
    }

    public Date getDate(){
        return date;
    }

    public String getStatus(){
        return status;
    }

    public void setUserID(int userID){
        this.userID = userID;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public void setDate(Date date){
        this.date = date;
    }
}
