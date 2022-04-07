package pl.britenet.btntrainbackshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.britenet.btntrainbackshop.service.AuthenticationService;
import pl.czarek.adminpanel.obj.productOptions.Product;
import pl.czarek.adminpanel.service.ProductService;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/product")
@CrossOrigin("null")
public class productController {

    private ProductService productService;
    private AuthenticationService authenticationService;


    @Autowired
    public productController(ProductService productService, AuthenticationService authenticationService){
        this.productService = productService;
        this.authenticationService = authenticationService;
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
    public ResponseEntity<Object> createProduct(@RequestBody Product product, @RequestHeader("Authorization") String token){
        if(authenticationService.isAuthenticated(token)){
            productService.createProduct(product);
            return ResponseEntity.status(HttpStatus.CREATED).body(null);
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
    }

    @PutMapping
    public ResponseEntity<Object> updateProduct(@RequestBody Product product, @RequestHeader("Authorization") String token){
        if(authenticationService.isAuthenticated(token)){
            productService.updateProduct(product);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Object> removeProduct(@PathVariable int productId, @RequestHeader("Authorization") String token){
        if(authenticationService.isAuthenticated(token)){
            productService.removeProduct(productId);
            return ResponseEntity.status(HttpStatus.GONE).body(null);
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
    }
}
