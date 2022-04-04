package pl.czarek.adminpanel.service;

import pl.czarek.adminpanel.builder.ProductOrderBuilder;
import pl.czarek.adminpanel.builder.UserBuilder;
import pl.czarek.adminpanel.obj.productOptions.Product;
import pl.czarek.adminpanel.obj.productOrderOptions.ProductOrder;
import pl.czarek.adminpanel.obj.userOptions.User;

import java.sql.*;
import java.util.ArrayList;
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

    public Optional<ArrayList<User>> findAll() {
        try {
            ArrayList<User> users = this.databaseService.performQuery("SELECT * FROM user", resultSet -> {
                ArrayList<User> usersQueries = new ArrayList<>();
                while (resultSet.next()) {

                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String login = resultSet.getString("login");
                    String password = resultSet.getString("password");
                    Date createDate = resultSet.getDate("createDate");

                    usersQueries.add(new UserBuilder(id)
                            .setName(name)
                            .setLogin(login)
                            .setPassword(password)
                            .setDate(createDate)
                            .getUser());
                }
                return usersQueries;
            });
            return Optional.ofNullable(users);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
