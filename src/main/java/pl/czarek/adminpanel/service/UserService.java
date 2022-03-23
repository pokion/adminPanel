package pl.czarek.adminpanel.service;

import pl.czarek.adminpanel.builder.UserBuilder;
import pl.czarek.adminpanel.obj.userOptions.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserService {

    private final DatabaseService databaseService;

    public UserService(DatabaseService databaseService){
        this.databaseService = databaseService;
    }

    public void createUser(User user){
        try{
            this.databaseService.performDML(
                    "INSERT INTO user(name, login, password) VALUE ('"+ user.getName() +"'," +
                            "'"+ user.getLogin() + "',"+
                            "'"+ user.getPassword() +
                            "')"
            );
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Optional<User> findUser(int id){
        try (Connection connection = this.databaseService.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT * FROM user WHERE id="+id
             )){
            ResultSet results = statement.executeQuery();
            if (results.next()){
                int idUser = results.getInt("id");
                String name = results.getString("name");
                String login = results.getString("login");
                String password = results.getString("password");

                User user = new UserBuilder(idUser)
                        .setName(name)
                        .setLogin(login)
                        .setPassword(password)
                        .getUser();

                return Optional.of(user);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return Optional.empty();
    }

    public void updateUser(User user){
        if (this.findUser(user.getId()).isPresent()){
            try{
                this.databaseService.performDML(
                        "UPDATE user SET name = '"+ user.getName() +"', " +
                                "login = '"+ user.getLogin() +"', " +
                                "password = '"+ user.getPassword() +"' WHERE id="+ user.getId()
                );
            }catch (Exception e){
                e.printStackTrace();
            }
        } else {
            throw new IllegalStateException("No user under given ID");
        }
    }

    public void removeUser(int id){
        if (this.findUser(id).isPresent()){
            try {
                this.databaseService.performDML(
                        "DELETE FROM user WHERE id = "+ id
                );
            }catch (Exception e){
                e.printStackTrace();
            }
        } else {
            throw new IllegalStateException("No user under given ID");
        }
    }
}
