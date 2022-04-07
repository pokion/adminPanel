package pl.britenet.btntrainbackshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.britenet.btntrainbackshop.service.AuthenticationService;
import pl.czarek.adminpanel.obj.productOrderOptions.ProductOrder;
import pl.czarek.adminpanel.service.ProductOrderService;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/productOrder")
@CrossOrigin("null")
public class productOrderController {

    private ProductOrderService productOrderService;
    private AuthenticationService authenticationService;

    @Autowired
    public productOrderController(ProductOrderService productOrderService, AuthenticationService authenticationService){
        this.productOrderService = productOrderService;
        this.authenticationService = authenticationService;
    }

    @GetMapping
    public ResponseEntity<ArrayList<ProductOrder>> getAllProductOrders(){
        Optional<ArrayList<ProductOrder>> productOrder = productOrderService.findAll();
        return ResponseEntity.of(productOrder);
    }

    @GetMapping("/{productOrderId}")
    public ResponseEntity<ProductOrder> getProductOrder(@PathVariable int productOrderId){
        Optional<ProductOrder> productOrder = productOrderService.findProductOrder(productOrderId);
        return ResponseEntity.of(productOrder);
    }

    @PostMapping
    public ResponseEntity<Object> createProductOrder(@RequestBody ProductOrder productOrder, @RequestHeader("Authorization") String token){
        if(authenticationService.isAuthenticated(token)){
            productOrderService.createProductOrder(productOrder);
            return ResponseEntity.status(HttpStatus.CREATED).body(null);
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
    }

    @PutMapping
    public ResponseEntity<Object> updateProductOrder(@RequestBody ProductOrder productOrder, @RequestHeader("Authorization") String token){
        if(authenticationService.isAuthenticated(token)){
            productOrderService.updateProductOrder(productOrder);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
    }

    @DeleteMapping("/{productOrderId}")
    public ResponseEntity<Object> removeProductOrder(@PathVariable int productOrderId, @RequestHeader("Authorization") String token){
        if(authenticationService.isAuthenticated(token)){
            productOrderService.removeProductOrder(productOrderId);
            return ResponseEntity.status(HttpStatus.GONE).body(null);
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
    }
}
