package pl.czarek.adminpanel.service;

import pl.czarek.adminpanel.obj.userOption.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserService {

    private final Map<Integer, User> users;

    public UserService(){
        this.users = new HashMap<>();
    }

    public void createUser(User user){
        this.users.put(user.getId(), user);
    }

    public Optional<User> findUser(int id){
        return Optional.ofNullable(this.users.get(id));
    }

    public void updateUser(int id, String name, String login, String password){
        this.users.get(id).setName(name);
        this.users.get(id).setLogin(login);
        this.users.get(id).setPassword(password);
    }

    public void removeUser(int id){
        this.users.remove(id);
    }
}
