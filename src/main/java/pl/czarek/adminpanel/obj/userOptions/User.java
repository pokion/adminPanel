package pl.czarek.adminpanel.obj.userOptions;

import java.sql.Date;

public class User {
    private int id;
    private String name;
    private String login;
    private String  password;
    private Date createDate;

    public User(){}

    public  User(int id){
        this.id = id;
    }

    public User(int id, String name, String login, String password){
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getLogin(){
        return login;
    }

    public String getPassword(){
        return password;
    }

    public Date getCreateDate(){
        return createDate;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setLogin(String login){
        this.login = login;
    }

    public void setPassword(String password){
        this.password = password;
    }
    public void setDate(Date date){
        this.createDate = date;
    }
}
