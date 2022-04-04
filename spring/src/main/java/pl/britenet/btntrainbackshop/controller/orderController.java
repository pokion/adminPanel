package pl.britenet.btntrainbackshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.czarek.adminpanel.obj.orderOptions.Order;
import pl.czarek.adminpanel.obj.productOptions.Product;
import pl.czarek.adminpanel.service.OrderService;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class orderController {

    private OrderService orderService;

    @Autowired
    public orderController(OrderService orderService){
        this.orderService = orderService;
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
    public void createOrder(@RequestBody Order order){
        orderService.createOrder(order);
    }

    @PutMapping
    public void updateOrder(@RequestBody Order order){
        orderService.updateOrder(order);
    }

    @DeleteMapping("/{orderId}")
    public void removeOrder(@PathVariable int orderId){
        orderService.removeOrder(orderId);
    }
}
