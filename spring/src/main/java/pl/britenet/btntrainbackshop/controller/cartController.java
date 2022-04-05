package pl.britenet.btntrainbackshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.czarek.adminpanel.obj.productOrderOptions.ProductOrder;
import pl.czarek.adminpanel.service.OrderService;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class cartController {

    private OrderService orderService;

    @Autowired
    public cartController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<ArrayList<ProductOrder>> getCartByID(@PathVariable int orderId){
        Optional<ArrayList<ProductOrder>> cart = orderService.getLinked(orderId);
        return ResponseEntity.of(cart);
    }
}
