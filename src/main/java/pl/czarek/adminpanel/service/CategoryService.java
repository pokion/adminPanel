package pl.czarek.adminpanel.service;

import pl.czarek.adminpanel.io.output;
import pl.czarek.adminpanel.obj.categoryOptions.Category;

import java.util.*;


public class CategoryService {

    private final DatabaseService databaseService;
    private final Map<Integer, Category> categories;

    public CategoryService(DatabaseService databaseService){
        this.databaseService = databaseService;
        this.categories = new HashMap<>();
    }

    public void createCategory(Category category){
        this.categories.put(category.getId(), category);
        this.databaseService.performDML(
                "INSERT INTO category(name) VALUE ('"+ category.getName() +"')"
        );
    }

    public Optional<Category> findCategory(int id){
        return Optional.ofNullable(this.categories.get(id));
    }

    public void updateCategory(Category category){
         if (this.categories.containsKey(category.getId())){
             this.categories.replace(category.getId(), category);
             this.databaseService.performDML(
                     "UPDATE category SET name = '"+ category.getName() +"' WHERE id="+ category.getId()
             );
         } else {
             throw new IllegalStateException("No category under given ID");
         }
    }

    public  void removeCategory(int id){
        this.categories.remove(id);
    }
}
