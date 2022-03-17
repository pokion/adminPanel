package pl.czarek.adminpanel.service;

import pl.czarek.adminpanel.obj.categoryOptions.Category;

import java.util.*;


public class CategoryService {

    private final Map<Integer, Category> categories;

    public CategoryService(){
        this.categories = new HashMap<>();
    }

    public void createCategory(Category category){
        this.categories.put(category.getId(), category);
    }

    public Optional<Category> findCategory(int id){
        return Optional.ofNullable(this.categories.get(id));
    }

    public void updateCategory(int id, String name){
        this.categories.get(id).setName(name);
    }

    public  void removeCategory(int id){
        this.categories.remove(id);
    }
}
