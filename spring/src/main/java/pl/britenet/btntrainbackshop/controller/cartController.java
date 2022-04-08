package pl.britenet.btntrainbackshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.czarek.adminpanel.obj.productOrderOptions.ProductOrder;
import pl.czarek.adminpanel.service.OrderService;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/cart")
@CrossOrigin("null")
public class cartController {

    private OrderService orderService;

    @Autowired
    public cartController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping
    public getCarts()


}
