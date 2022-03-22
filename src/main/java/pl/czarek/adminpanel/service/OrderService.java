package pl.czarek.adminpanel.service;

import pl.czarek.adminpanel.builder.OrderBuilder;
import pl.czarek.adminpanel.obj.orderOptions.Order;

import java.sql.*;
import java.util.Optional;

public class OrderService {

    private final DatabaseService databaseService;

    public OrderService(DatabaseService databaseService){
        this.databaseService = databaseService;
    }

    public void createOrder(Order order){
        this.databaseService.performDML(
                "INSERT INTO orders (userID, status) VALUES (" +
                        "'"+ order.getUserID() +"',"+
                        "'"+ order.getStatus() +"')"
        );
    }

    public void updateOrder(Order order){
        if (this.findOrder(order.getId()).isPresent()){
            this.databaseService.performDML(
                    "UPDATE orders SET " +
                            "userID ='" + order.getUserID() + "'," +
                            "status ='" + order.getStatus() + "' " +
                            "WHERE id="+ order.getId()
            );
        }else throw new IllegalStateException("No Order under given ID");
    }

    public Optional<Order> findOrder(int id){
        try (Connection connection = this.databaseService.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT * FROM orders WHERE id="+id
             )){
            ResultSet results = statement.executeQuery();
            if (results.next()){
                int idOrder = results.getInt("id");
                int userID = results.getInt("userID");
                String status = results.getNString("status");
                Date date = results.getDate("dataOrder");

                Order order = new OrderBuilder(idOrder)
                        .setUserID(userID)
                        .setStatus(status)
                        .setDate(date).getOrder();

                return Optional.of(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    public void removeOrder(int id){
        this.databaseService.performDML(
                "DELETE FROM orders WHERE id="+id
        );
    }
}
