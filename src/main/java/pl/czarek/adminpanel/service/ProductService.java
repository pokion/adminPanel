package pl.czarek.adminpanel.service;

import pl.czarek.adminpanel.builder.ProductBuilder;
import pl.czarek.adminpanel.obj.productOptions.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ProductService {

    private final DatabaseService databaseService;

    public ProductService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public void createProduct(Product product) {
        this.databaseService.performDML(
                "INSERT INTO product(name, categoryID) " +
                        "VALUE ('"+ product.getName() +"', '"+ product.getCategoryID() +"')"
        );
    }

    public void updateProduct(Product product) {
        if(this.findProduct(product.getId()).isPresent()){
            this.databaseService.performDML(
                    "UPDATE product SET name = '"+ product.getName() +"', categoryID = '"+ product.getCategoryID() +"' WHERE id="+ product.getId()
            );
        } else {
            throw new IllegalStateException("No product under given ID");
        }
    }

    public Optional<Product> findProduct(int id) {
        try (Connection connection = this.databaseService.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT * FROM product WHERE id="+id
             )){
            ResultSet results = statement.executeQuery();
            if (results.next()){
                int idProduct = results.getInt("id");
                int categoryID = results.getInt("categoryID");
                String name = results.getString("name");

                Product product = new ProductBuilder(idProduct)
                        .setName(name)
                        .setCategory(categoryID)
                        .getProduct();

                return Optional.of(product);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return Optional.empty();
    }

    public void removeProduct(int id) {
        if (this.findProduct(id).isPresent()){
            this.databaseService.performDML(
                    "DELETE FROM product WHERE id = "+ id
            );
        } else {
            throw new IllegalStateException("No product under given ID");
        }
    }
}
