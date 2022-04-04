package pl.britenet.btntrainbackshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.czarek.adminpanel.obj.productOrderOptions.ProductOrder;
import pl.czarek.adminpanel.service.ProductOrderService;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/productOrder")
public class productOrderController {

    private ProductOrderService productOrderService;

    @Autowired
    public productOrderController(ProductOrderService productOrderService){
        this.productOrderService = productOrderService;
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
    public void createProductOrder(@RequestBody ProductOrder productOrder){
        productOrderService.createProductOrder(productOrder);
    }

    @PutMapping
    public void updateProductOrder(@RequestBody ProductOrder productOrder){
        productOrderService.updateProductOrder(productOrder);
    }

    @DeleteMapping("/{productOrderId}")
    public void removeProductOrder(@PathVariable int productOrderId){
        productOrderService.removeProductOrder(productOrderId);
    }
}
