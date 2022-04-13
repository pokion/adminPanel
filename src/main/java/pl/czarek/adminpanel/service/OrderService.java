package pl.czarek.adminpanel.service;

import pl.czarek.adminpanel.builder.*;
import pl.czarek.adminpanel.obj.orderOptions.Order;
import pl.czarek.adminpanel.obj.productOrderOptions.ProductOrder;

import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;

public class OrderService {

    private final DatabaseService databaseService;

    public OrderService(DatabaseService databaseService){
        this.databaseService = databaseService;
    }

    public Optional<ArrayList<Order>> getOrderNew(){
        try {
            ArrayList<Order> orders = this.databaseService.performQuery("SELECT * FROM orders ORDER BY id DESC LIMIT 1", resultSet -> {
                ArrayList<Order> ordersQuery = new ArrayList<>();
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    int userID = resultSet.getInt("userID");
                    String status = resultSet.getString("status");
                    Date dataOrder = resultSet.getDate("dataOrder");

                    ordersQuery.add(new OrderBuilder(id)
                            .setDate(dataOrder)
                            .setStatus(status)
                            .setUser(new UserBuilder(userID).getUser())
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

    public void createOrder(Order order){
        try{
            this.databaseService.performDML(
                    "INSERT INTO orders (userID, status, name, ursname, phoneNumber, email, postCode, city, street, building, paymentMethod) VALUES (" +
                            "'"+ order.getUser().getId() +"',"+
                            "'"+ order.getStatus() +"'," +
                            "'"+ order.getName() +"'," +
                            "'"+ order.getUrsname() +"'," +
                            "'"+ order.getPhoneNumber() +"'," +
                            "'"+ order.getEmail() +"'," +
                            "'"+ order.getPostCode() +"'," +
                            "'"+ order.getCity() +"'," +
                            "'"+ order.getStreet() +"'," +
                            "'"+ order.getBuilding() +"'," +
                            "'"+ order.getPaymentMethod() +"' " +
                            ")"
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
                                "userID ='" + order.getUser().getId() + "'," +
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
                        .setUser(new UserBuilder(userID).getUser())
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

    public Optional<ArrayList<ProductOrder>> getLinked(int id){
        try {
            ArrayList<ProductOrder> productOrders = this.databaseService.performQuery(
                    "SELECT orders.id ,orders.status, orders.dataOrder, user.id AS userID, user.name AS userName, user.login AS userLogin, user.password AS userPassword, user.createDate AS userCreateDate,\n" +
                            "\t\tproduct_order.id AS productOrderID, product_order.quantity AS productOrderQuantity, product_order.createDate AS productOrderCreateDate,\n" +
                            "        product.id AS productID, product.name AS productName, category.id AS categoryID, product.price AS productPrice category.name AS categoryName\n" +
                            "FROM orders\n" +
                            "INNER JOIN user ON orders.userID = user.id\n" +
                            "INNER JOIN product_order ON product_order.orderID = orders.id\n" +
                            "INNER JOIN product ON product_order.productID = product.id\n" +
                            "INNER JOIN category ON product.categoryID = category.id\n" +
                            "WHERE user.id = "+id,
                    resultSet -> {
                        ArrayList<ProductOrder> query = new ArrayList<>();
                        while (resultSet.next()){
                            query.add(new ProductOrderBuilder(resultSet.getInt("productOrderID"))
                                    .setPrice(resultSet.getFloat("productPrice"))
                                    .setDate(resultSet.getDate("productOrderCreateDate"))
                                    .setQuantity(resultSet.getInt("productOrderQuantity"))
                                    .setOrder(new OrderBuilder(resultSet.getInt("id"))
                                            .setStatus(resultSet.getString("status"))
                                            .setDate(resultSet.getDate("dataOrder"))
                                            .setUser(new UserBuilder(resultSet.getInt("userID"))
                                                    .setLogin(resultSet.getString("userLogin"))
                                                    .setPassword(resultSet.getString("userPassword"))
                                                    .getUser())
                                            .getOrder())
                                    .setProduct(new ProductBuilder(resultSet.getInt("productID"))
                                            .setName(resultSet.getString("productName"))
                                            .setCategory(new CategoryBuilder(resultSet.getInt("categoryID"))
                                                    .setName(resultSet.getString("categoryName"))
                                                    .getCategory())
                                            .getProduct())
                                    .getProductOrder());
                        }
                        return query;
                    }
            );
            return Optional.ofNullable(productOrders);
        }catch (Exception e){
            e.printStackTrace();
            return Optional.empty();
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
                            .setUser(new UserBuilder(userID).getUser())
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

    //public Optional<ArrayList<>>
}
