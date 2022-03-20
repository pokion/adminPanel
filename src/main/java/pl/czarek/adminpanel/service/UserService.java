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

    public void updateUser(User user){
        if (this.users.containsKey(user.getId())){
            this.users.replace(user.getId(), user);
        } else {
            throw new IllegalStateException("No User under given ID");
        }
    }

    public void removeUser(int id){
        this.users.remove(id);
    }
}
