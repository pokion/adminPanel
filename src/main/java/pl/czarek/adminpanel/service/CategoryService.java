package pl.czarek.adminpanel.service;

import pl.czarek.adminpanel.obj.categoryOptions.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class CategoryService {

    private final List<Category> categories;

    public CategoryService(){
        this.categories = new ArrayList<>();
    }

    public void createCategory(int id, String name){
        this.categories.add(new Category(id, name));
    }

    public Optional<Category> findCategory(int id){
        return this.categories.stream()
                .filter( category -> category.getId() == id)
                .findFirst();
    }

    public void updateCategory(int id, String name){
        this.categories.stream()
                .filter( category -> category.getId() == id)
                .findFirst()
                .ifPresent( category -> category.setName(name));
    }

    public  void removeCategory(int id){
        this.categories.removeIf( category -> category.getId() == id);
    }
}
