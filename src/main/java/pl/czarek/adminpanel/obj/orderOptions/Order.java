package pl.czarek.adminpanel.obj.orderOptions;

import pl.czarek.adminpanel.obj.userOptions.User;

import java.sql.Date;

public class Order {
    private int id;
    private User user;
    private String status;
    private String name;
    private String ursname;
    private int phoneNumber;
    private String email;
    private String postCode;
    private String city;
    private String street;
    private String  building;
    private String paymentMethod;
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

    public String getName(){
        return name;
    }

    public String getUrsname(){
        return ursname;
    }

    public String getEmail(){
        return email;
    }

    public String getPostCode(){
        return postCode;
    }

    public int getPhoneNumber(){
        return phoneNumber;
    }

    public String getCity(){
        return city;
    }

    public String getStreet(){
        return street;
    }

    public String getPaymentMethod(){
        return paymentMethod;
    }

    public String getBuilding(){
        return building;
    }

    public String getStatus(){
        return status;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setUrsname(String ursname) {
        this.ursname = ursname;
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
