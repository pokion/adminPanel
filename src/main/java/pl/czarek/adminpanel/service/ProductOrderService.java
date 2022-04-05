package pl.czarek.adminpanel.service;

import pl.czarek.adminpanel.builder.CategoryBuilder;
import pl.czarek.adminpanel.builder.OrderBuilder;
import pl.czarek.adminpanel.builder.ProductBuilder;
import pl.czarek.adminpanel.builder.ProductOrderBuilder;
import pl.czarek.adminpanel.obj.categoryOptions.Category;
import pl.czarek.adminpanel.obj.productOrderOptions.ProductOrder;
import pl.czarek.adminpanel.obj.userOptions.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

public class ProductOrderService {

    private final DatabaseService databaseService;

    public ProductOrderService(DatabaseService databaseService){
        this.databaseService = databaseService;
    }

    public void createProductOrder(ProductOrder productOrder){
        try{
            this.databaseService.performDML(
                    "INSERT INTO product_order (productID, orderID, quantity, price) VALUES (" +
                            "'"+ productOrder.getProduct().getId() +"'," +
                            "'"+ productOrder.getOrder().getId() +"'," +
                            "'"+ productOrder.getQuantity() +"'," +
                            "'"+ productOrder.getPrice() +"'" +
                            ")"
            );
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateProductOrder(ProductOrder productOrder){
        if (this.findProductOrder(productOrder.getId()).isPresent()) {
            try{
                this.databaseService.performDML(
                        "UPDATE product_order SET " +
                                "productID ='" + productOrder.getProduct().getId() + "'," +
                                "orderID ='" + productOrder.getOrder().getId() + "'," +
                                "quantity ='" + productOrder.getQuantity() + "'," +
                                "price ='" + productOrder.getPrice() + "'" +
                                "WHERE id=" + productOrder.getId()
                );
            }catch (Exception e){
                e.printStackTrace();
            }
        } else throw new IllegalStateException("No productOrder under given ID");
    }

    public Optional<ProductOrder> findProductOrder(int id) {
        try (Connection connection = this.databaseService.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT * FROM product_order WHERE id="+id
             )) {
            ResultSet results = statement.executeQuery();
            if (results.next()){
                int idPOrder = results.getInt("id");
                int productID = results.getInt("productID");
                int orderID = results.getInt("orderID");
                int quantity = results.getInt("quantity");
                float price = results.getFloat("price");
                Date date = results.getDate("createDate");

                ProductOrder productOrder = new ProductOrderBuilder(idPOrder)
                        .setProduct(new ProductBuilder(productID).getProduct())
                        .setOrder(new OrderBuilder(orderID).getOrder())
                        .setQuantity(quantity)
                        .setPrice(price)
                        .setDate(date).getProductOrder();

                return Optional.of(productOrder);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    public void removeProductOrder(int id){
        try{
            this.databaseService.performDML(
                    "DELETE FROM product_order WHERE id = "+ id
            );
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Optional<ArrayList<ProductOrder>> findAll() {
        try {
            ArrayList<ProductOrder> productOrders = this.databaseService.performQuery("SELECT * FROM product_order", resultSet -> {
                ArrayList<ProductOrder> productOrdersQueries = new ArrayList<>();
                while (resultSet.next()) {

                    int id = resultSet.getInt("id");
                    int productID = resultSet.getInt("productID");
                    int orderID = resultSet.getInt("orderID");
                    int quantity = resultSet.getInt("quantity");
                    float price = resultSet.getFloat("price");
                    Date createDate = resultSet.getDate("createDate");

                    productOrdersQueries.add(new ProductOrderBuilder(id)
                            .setPrice(price)
                            .setOrder(new OrderBuilder(orderID).getOrder())
                            .setProduct(new ProductBuilder(productID).getProduct())
                            .setQuantity(quantity)
                            .setDate(createDate)
                            .getProductOrder());
                }
                return productOrdersQueries;
            });
            return Optional.ofNullable(productOrders);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
