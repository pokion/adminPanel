package pl.czarek.adminpanel.service;

import pl.czarek.adminpanel.builder.CategoryBuilder;
import pl.czarek.adminpanel.builder.ProductBuilder;
import pl.czarek.adminpanel.obj.productOptions.Product;

import java.util.*;

import static java.sql.Types.NULL;

public class ProductService {

    private final DatabaseService databaseService;

    public ProductService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public void createProduct(Product product) {
        try {
            String  categoryId;
            if (product.getCategory().getId() != 0){
                categoryId = String.valueOf(product.getCategory().getId());
            }else {
                categoryId = "NULL";
            }

            this.databaseService.performDML(
                    "INSERT INTO product(name, categoryID) " +
                            "VALUE ('"+ product.getName() +"', "+ categoryId +")"
            );
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateProduct(Product product) {
        try {
            if(this.findProduct(product.getId()).isPresent()){
                this.databaseService.performDML(
                        "UPDATE product SET name = '"+ product.getName() +"', categoryID = '"+ product.getCategory().getId() +"' WHERE id="+ product.getId()
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
            String query = String.format(
                    "SELECT product.id AS ID, product.categoryID, product.name, category.name AS categoryName \n" +
                            "FROM product \n" +
                            "LEFT JOIN category ON product.categoryID = category.id " +
                            "WHERE product.id = %d"
                    , id);

            Product product = this.databaseService.performQuery(query, resultSet -> {
                if(resultSet.next()){
                    String name = resultSet.getString("name");
                    String categoryName = resultSet.getString("categoryName");
                    int categoryId = resultSet.getInt("categoryID");

                    return new ProductBuilder(id)
                            .setName(name)
                            .setCategory(new CategoryBuilder(categoryId)
                                    .setName(categoryName)
                                    .getCategory())
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
            ArrayList<Product> products = this.databaseService.performQuery(
                    "SELECT product.id AS ID, product.categoryID, product.price, product.name, category.name AS categoryName, GROUP_CONCAT(image.path) AS path\n" +
                            "FROM product\n" +
                            "LEFT JOIN imagelink ON imagelink.productID = product.id\n" +
                            "LEFT JOIN image ON imagelink.imageID = image.id\n" +
                            "LEFT JOIN category ON product.categoryID = category.id\n" +
                            "GROUP BY product.name\n"
                    , resultSet -> {
                ArrayList<Product> productsQuery = new ArrayList<>();
                while (resultSet.next()){

                    int id = resultSet.getInt("id");
                    String path = resultSet.getString("path");
                    String name = resultSet.getString("name");
                    String categoryName = resultSet.getString("categoryName");
                    float price = resultSet.getFloat("price");
                    int categoryId = resultSet.getInt("categoryID");

                    productsQuery.add(new ProductBuilder(id)
                            .setName(name)
                                    .setPrice(price)
                            .setCategory(new CategoryBuilder(categoryId)
                                    .setName(categoryName)
                                    .getCategory())
                                    .setPath(path)
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

    public ArrayList<Product> getLinked(){
        try {
            ArrayList<Product> products = this.databaseService.performQuery(
                    "SELECT category.id AS 'category_id', category.name AS 'category_name'," +
                            "product.id, product.categoryID, category.name FROM product " +
                            "INNER JOIN category ON product.categoryID = category.id",
                    resultSet -> {
                        ArrayList<Product> queryReturn = new ArrayList<>();
                        while (resultSet.next()){
                            queryReturn.add(new ProductBuilder(resultSet.getInt("id"))
                                    .setCategory(new CategoryBuilder(resultSet.getInt("category_id"))
                                            .setName(resultSet.getString("category_name")).getCategory())
                                    .setName(resultSet.getString("name"))
                                    .getProduct());
                        }
                        return queryReturn;
                    }
            );
            return products;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
