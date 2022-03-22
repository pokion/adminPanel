package pl.czarek.adminpanel.service;

import pl.czarek.adminpanel.builder.CategoryBuilder;
import pl.czarek.adminpanel.obj.categoryOptions.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


public class CategoryService {

    private final DatabaseService databaseService;

    public CategoryService(DatabaseService databaseService){
        this.databaseService = databaseService;
    }

    public void createCategory(Category category){
        this.databaseService.performDML(
                "INSERT INTO category(name) VALUE ('"+ category.getName() +"')"
        );
    }

    public Optional<Category> findCategory(int id){
        try (Connection connection = this.databaseService.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT * FROM category WHERE id = "+ id
             )){
            ResultSet results = statement.executeQuery();
            if (results.next()){
                int idCategory = results.getInt("id");
                String name = results.getString("name");

                Category category = new CategoryBuilder(idCategory)
                        .setName(name).getCategory();

                return Optional.of(category);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public void updateCategory(Category category){
         if (this.findCategory(category.getId()).isPresent()){

             this.databaseService.performDML(
                     "UPDATE category SET name = '"+ category.getName() +"' WHERE id="+ category.getId()
             );
         } else {
             throw new IllegalStateException("No category under given ID");
         }
    }

    public void removeCategory(int id){
        if (this.findCategory(id).isPresent()){
            this.databaseService.performDML(
                    "DELETE FROM category WHERE id = "+ id
            );
        } else {
            throw new IllegalStateException("No category under given ID");
        }

    }
}
