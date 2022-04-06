package pl.britenet.btntrainbackshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.czarek.adminpanel.obj.productOptions.Product;
import pl.czarek.adminpanel.service.ProductService;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/product")
@CrossOrigin("null")
public class productController {

    private ProductService productService;

    @Autowired
    public productController(ProductService productService){
        this.productService = productService;
    }


    @GetMapping
    public ResponseEntity<ArrayList<Product>> getAllProduct(){
        Optional<ArrayList<Product>> product = productService.findAll();
        return ResponseEntity.of(product);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable int productId){
        Optional<Product> product = productService.findProduct(productId);
        return ResponseEntity.of(product);
    }

    @PostMapping
    public void createProduct(@RequestBody Product product){
        productService.createProduct(product);
    }

    @PutMapping
    public void updateProduct(@RequestBody Product product){
        productService.updateProduct(product);
    }

    @DeleteMapping("/{productId}")
    public void removeProduct(@PathVariable int productId){
        productService.removeProduct(productId);
    }
}
