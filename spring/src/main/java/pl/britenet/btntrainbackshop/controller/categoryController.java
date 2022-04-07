package pl.britenet.btntrainbackshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.britenet.btntrainbackshop.service.AuthenticationService;
import pl.czarek.adminpanel.obj.categoryOptions.Category;
import pl.czarek.adminpanel.service.CategoryService;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/category")
@CrossOrigin("null")
public class categoryController {

    private CategoryService categoryService;
    private AuthenticationService authenticationService;

    @Autowired
    public categoryController(CategoryService categoryService, AuthenticationService authenticationService){
        this.categoryService = categoryService;
        this.authenticationService = authenticationService;
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
    public ResponseEntity<Object> createCategory(@RequestBody Category category, @RequestHeader("Authorization") String token){
        if(authenticationService.isAuthenticated(token)){
            categoryService.createCategory(category);
            return ResponseEntity.status(HttpStatus.CREATED).body(null);
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
    }

    @PutMapping
    public ResponseEntity<Object> updateCategory(@RequestBody Category category, @RequestHeader("Authorization") String token){
        if(authenticationService.isAuthenticated(token)){
            categoryService.updateCategory(category);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<Object> removeCategory(@PathVariable int categoryId, @RequestHeader("Authorization") String token){
        if(authenticationService.isAuthenticated(token)){
            categoryService.removeCategory(categoryId);
            return ResponseEntity.status(HttpStatus.GONE).body(null);
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
    }
}
