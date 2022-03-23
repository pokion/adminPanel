package pl.czarek.adminpanel.service;

import pl.czarek.adminpanel.builder.ProductOrderBuilder;
import pl.czarek.adminpanel.obj.productOrderOptions.ProductOrder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                    "INSERT INTO product_order (productID, orderID, quantity, price, inStock) VALUES (" +
                            "'"+ productOrder.getProductID() +"'," +
                            "'"+ productOrder.getOrderID() +"'," +
                            "'"+ productOrder.getQuantity() +"'," +
                            "'"+ productOrder.getPrice() +"'," +
                            "'"+ productOrder.getInStock() +"'" +
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
                                "productID ='" + productOrder.getProductID() + "'," +
                                "orderID ='" + productOrder.getOrderID() + "'," +
                                "quantity ='" + productOrder.getQuantity() + "'," +
                                "price ='" + productOrder.getPrice() + "'," +
                                "inStock ='" + productOrder.getInStock() + "' " +
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
                int inStock = results.getInt("inStock");

                ProductOrder productOrder = new ProductOrderBuilder(idPOrder)
                        .setProductID(productID)
                        .setOrderID(orderID)
                        .setQuantity(quantity)
                        .setPrice(price)
                        .setInStock(inStock).getProductOrder();

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
}
