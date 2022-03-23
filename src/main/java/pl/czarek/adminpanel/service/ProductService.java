package pl.czarek.adminpanel.service;

import pl.czarek.adminpanel.builder.ProductBuilder;
import pl.czarek.adminpanel.io.output;
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
        try {
            this.databaseService.performDML(
                    "INSERT INTO product(name, categoryID) " +
                            "VALUE ('"+ product.getName() +"', '"+ product.getCategoryID() +"')"
            );
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateProduct(Product product) {
        try {
            if(this.findProduct(product.getId()).isPresent()){
                this.databaseService.performDML(
                        "UPDATE product SET name = '"+ product.getName() +"', categoryID = '"+ product.getCategoryID() +"' WHERE id="+ product.getId()
                );
            } else {
                throw new IllegalStateException("No product under given ID");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Optional<Product> findProduct(int id) {
        try{
            String query = String.format("SELECT * FROM product WHERE id=%d", id);

            Product product = this.databaseService.performQuery(query, resultSet -> {
                if(resultSet.next()){
                    String name = resultSet.getString("name");
                    int categoryId = resultSet.getInt("categoryID");

                    return new ProductBuilder(id)
                            .setName(name)
                            .setCategory(categoryId)
                            .getProduct();
                }

                return null;
            });

            return Optional.ofNullable(product);
        }catch (Exception e){
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public void removeProduct(int id) {
        if (this.findProduct(id).isPresent()){
            try{
                this.databaseService.performDML(
                        "DELETE FROM product WHERE id = "+ id
                );
            }catch (Exception e){
                e.printStackTrace();
            }
        } else {
            throw new IllegalStateException("No product under given ID");
        }
    }

    public Optional<ArrayList<Product>> findAll(){
        try{
            ArrayList<Product> products = this.databaseService.performQuery("SELECT * FROM product", resultSet -> {
                ArrayList<Product> productsQuery = new ArrayList<>();
                while (resultSet.next()){

                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    int categoryId = resultSet.getInt("categoryID");

                    productsQuery.add(new ProductBuilder(id)
                            .setName(name)
                            .setCategory(categoryId)
                            .getProduct());
                }
                return productsQuery;
            });
            return Optional.ofNullable(products);
        }catch (Exception e){
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
