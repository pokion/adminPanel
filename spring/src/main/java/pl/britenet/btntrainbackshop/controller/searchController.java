package pl.britenet.btntrainbackshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.czarek.adminpanel.obj.productOptions.Product;
import pl.czarek.adminpanel.service.ProductService;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/search")
@CrossOrigin("null")
public class searchController {

    private ProductService productService;

    @Autowired
    public searchController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/{stringForSearch}")
    public ResponseEntity<ArrayList<Product>> getSearch(@PathVariable String stringForSearch){
        Optional<ArrayList<Product>> products = productService.findFromSearch(stringForSearch);
        return ResponseEntity.of(products);
    }
}
