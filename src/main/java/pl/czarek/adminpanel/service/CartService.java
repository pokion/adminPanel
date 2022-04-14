package pl.czarek.adminpanel.service;

import pl.czarek.adminpanel.builder.CartBuilder;
import pl.czarek.adminpanel.builder.OrderBuilder;
import pl.czarek.adminpanel.builder.ProductBuilder;
import pl.czarek.adminpanel.builder.ProductOrderBuilder;
import pl.czarek.adminpanel.obj.cart.Cart;
import pl.czarek.adminpanel.obj.categoryOptions.Category;
import pl.czarek.adminpanel.obj.orderOptions.Order;
import pl.czarek.adminpanel.obj.productOptions.Product;
import pl.czarek.adminpanel.obj.productOrderOptions.ProductOrder;

import javax.xml.crypto.Data;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Optional;

public class CartService {
    private final DatabaseService databaseService;

    public CartService(DatabaseService databaseService){
        this.databaseService = databaseService;
    }

    public Optional<ArrayList<ProductOrder>> getAllCartByOrderID(int id){
        try{
            ArrayList<ProductOrder> productOrders = this.databaseService.performQuery(
                    "SELECT * FROM `product_order` WHERE `orderID` = "+id,
                    resultSet -> {
                        ArrayList<ProductOrder> query = new ArrayList<>();
                        while (resultSet.next()){
                            int idd = resultSet.getInt("id");
                            int productID = resultSet.getInt("productID");
                            int orderID = resultSet.getInt("orderID");
                            int quantity = resultSet.getInt("quantity");
                            Date createDate = resultSet.getDate("createDate");


                            query.add(new ProductOrderBuilder()
                                            .setQuantity(quantity)
                                            .setDate(createDate)
                                            .setOrder(new Order(orderID))
                                            .setProduct(new Product(productID))
                                            .getProductOrder()
                                    );
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

    public Optional<ArrayList<Cart>> getAllCart(int id){
        try{
            ArrayList<Cart> carts = this.databaseService.performQuery(
                    "SELECT product_order.quantity, product_order.createDate AS productDate, product_order.id AS orderID, product.name, product.price, orders.status, orders.dataOrder AS orderDate, image.path, orders.id\n" +
                            "FROM product_order\n" +
                            "INNER JOIN orders ON product_order.orderID = orders.id\n" +
                            "INNER JOIN product ON product_order.productID = product.id\n" +
                            "INNER JOIN imagelink ON product.id = imagelink.productID\n" +
                            "INNER JOIN image ON imagelink.imageID = image.id\n" +
                            "INNER JOIN user ON orders.userID = user.id\n" +
                            "WHERE user.id = "+id +
                            " GROUP BY orders.id", resultSet -> {
                        ArrayList<Cart> query = new ArrayList<>();
                        while (resultSet.next()){
                            int queantity = resultSet.getInt("quantity");
                            Date productDate = resultSet.getDate("productDate");
                            int orderID = resultSet.getInt("orderID");
                            String name = resultSet.getString("name");
                            float price = resultSet.getFloat("price");
                            String statuts = resultSet.getString("status");
                            Date orderDate = resultSet.getDate("orderDate");
                            String path = resultSet.getString("path");
                            int cartId = resultSet.getInt("id");

                            query.add(new CartBuilder(cartId)
                                    .setOrder(new OrderBuilder(orderID)
                                            .setStatus(statuts)
                                            .setDate(orderDate)
                                            .getOrder())
                                    .setPath(path)
                                    .setProductOrder(new ProductOrderBuilder()
                                            .setDate(productDate)
                                            .setQuantity(queantity)
                                            .setProduct(new ProductBuilder()
                                                    .setName(name)
                                                    .setPrice(price)
                                                    .getProduct())
                                            .getProductOrder())
                                    .getCart());
                        }
                        return query;
                    }
            );
            return Optional.ofNullable(carts);
        }catch (Exception e){
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
