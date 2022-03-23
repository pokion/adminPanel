package pl.czarek.adminpanel.service;

import pl.czarek.adminpanel.builder.OrderBuilder;
import pl.czarek.adminpanel.obj.orderOptions.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;

public class OrderService {

    private final DatabaseService databaseService;

    public OrderService(DatabaseService databaseService){
        this.databaseService = databaseService;
    }

    public void createOrder(Order order){
        try{
            this.databaseService.performDML(
                    "INSERT INTO orders (userID, status) VALUES (" +
                            "'"+ order.getUserID() +"',"+
                            "'"+ order.getStatus() +"')"
            );
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateOrder(Order order){
        if (this.findOrder(order.getId()).isPresent()){
            try{
                this.databaseService.performDML(
                        "UPDATE orders SET " +
                                "userID ='" + order.getUserID() + "'," +
                                "status ='" + order.getStatus() + "' " +
                                "WHERE id="+ order.getId()
                );
            }catch (Exception e){
                e.printStackTrace();
            }
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
        try {
            this.databaseService.performDML(
                    "DELETE FROM orders WHERE id="+id
            );
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Optional<ArrayList<Order>> findAll(){
        try {
            ArrayList<Order> orders = this.databaseService.performQuery("SELECT * FROM orders", resultSet -> {
                ArrayList<Order> ordersQuery = new ArrayList<>();
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    int userID = resultSet.getInt("userID");
                    String status = resultSet.getString("status");
                    Date dataOrder = resultSet.getDate("dataOrder");

                    ordersQuery.add(new OrderBuilder(id)
                            .setDate(dataOrder)
                            .setStatus(status)
                            .setUserID(userID)
                            .getOrder());
                }
                return ordersQuery;
            });
            return Optional.ofNullable(orders);
        }catch (Exception e){
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
