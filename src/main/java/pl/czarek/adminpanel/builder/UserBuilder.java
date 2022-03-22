package pl.czarek.adminpanel.builder;

import pl.czarek.adminpanel.obj.userOptions.User;

public class UserBuilder {

    private final User user;

    public UserBuilder(){
        this.user = new User();
    }

    public UserBuilder(int id){
        this.user = new User(id);
    }

    public UserBuilder setName(String name){
        this.user.setName(name);
        return this;
    }

    public UserBuilder setLogin(String login){
        this.user.setLogin(login);
        return this;
    }

    public UserBuilder setPassword(String password){
        this.user.setPassword(password);
        return this;
    }

    public User getUser(){
        return this.user;
    }
}
