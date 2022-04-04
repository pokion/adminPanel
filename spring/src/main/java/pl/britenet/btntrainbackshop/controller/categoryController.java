package pl.britenet.btntrainbackshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.czarek.adminpanel.obj.categoryOptions.Category;
import pl.czarek.adminpanel.service.CategoryService;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class categoryController {

    private CategoryService categoryService;

    @Autowired
    public categoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<ArrayList<Category>> getAllCategories(){
        Optional<ArrayList<Category>> category = categoryService.findAll();
        return ResponseEntity.of(category);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<Category> getCategory(@PathVariable int categoryId){
        Optional<Category> category = categoryService.findCategory(categoryId);
        return ResponseEntity.of(category);
    }

    @PostMapping
    public void createCategory(@RequestBody Category category){
        categoryService.createCategory(category);
    }

    @PutMapping
    public void updateCategory(@RequestBody Category category){
        categoryService.updateCategory(category);
    }

    @DeleteMapping("/{categoryId}")
    public void removeCategory(@PathVariable int categoryId){
        categoryService.removeCategory(categoryId);
    }
}
