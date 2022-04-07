package pl.britenet.btntrainbackshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.britenet.btntrainbackshop.service.AuthenticationService;
import pl.czarek.adminpanel.obj.orderOptions.Order;
import pl.czarek.adminpanel.service.OrderService;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/order")
@CrossOrigin("null")
public class orderController {

    private OrderService orderService;
    private AuthenticationService authenticationService;

    @Autowired
    public orderController(OrderService orderService, AuthenticationService authenticationService){
        this.orderService = orderService;
        this.authenticationService = authenticationService;
    }

    @GetMapping
    public ResponseEntity<ArrayList<Order>> getAllOrders(){
        Optional<ArrayList<Order>> orders = orderService.findAll();
        return ResponseEntity.of(orders);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrder(@PathVariable int orderId){
        Optional<Order> order = orderService.findOrder(orderId);
        return ResponseEntity.of(order);
    }

    @PostMapping
    public ResponseEntity<Object> createOrder(@RequestBody Order order, @RequestHeader("Authorization") String token){
        if(authenticationService.isAuthenticated(token)){
            orderService.createOrder(order);
            return ResponseEntity.status(HttpStatus.CREATED).body(null);
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
    }

    @PutMapping
    public ResponseEntity<Object> updateOrder(@RequestBody Order order, @RequestHeader("Authorization") String token){
        if(authenticationService.isAuthenticated(token)){
            orderService.updateOrder(order);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Object> removeOrder(@PathVariable int orderId, @RequestHeader("Authorization") String token){
        if(authenticationService.isAuthenticated(token)){
            orderService.removeOrder(orderId);
            return ResponseEntity.status(HttpStatus.GONE).body(null);
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
    }
}
