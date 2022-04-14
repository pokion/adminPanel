package pl.britenet.btntrainbackshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.britenet.btntrainbackshop.service.AuthenticationService;
import pl.czarek.adminpanel.obj.cart.Cart;
import pl.czarek.adminpanel.obj.orderOptions.Order;
import pl.czarek.adminpanel.obj.productOrderOptions.ProductOrder;
import pl.czarek.adminpanel.obj.userOptions.User;
import pl.czarek.adminpanel.service.CartService;
import pl.czarek.adminpanel.service.OrderService;
import pl.czarek.adminpanel.service.ProductOrderService;
import pl.czarek.adminpanel.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cart")
@CrossOrigin("null")
public class cartController {

    private CartService cartService;
    private OrderService orderService;
    private ProductOrderService productOrderService;
    private ProductService productService;
    private AuthenticationService authenticationService;

    @Autowired
    public cartController(CartService cartService, AuthenticationService authenticationService, OrderService orderService, ProductOrderService productOrderService, ProductService productService){
        this.orderService = orderService;
        this.productOrderService = productOrderService;
        this.authenticationService = authenticationService;
        this.cartService = cartService;
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<ArrayList<Cart>> getCarts(@RequestHeader("Authorization") String token){
        if(authenticationService.isAuthenticated(token)){
            Optional<User> user = authenticationService.retrieveUserByToken(token);
            Optional<ArrayList<Cart>> carts =  cartService.getAllCart(user.get().getId());
            return ResponseEntity.of(carts);
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
    }

    @GetMapping("/{cartID}")
    public ResponseEntity<ArrayList<ProductOrder>> getAllCartsByOrderId(@RequestHeader("Authorization") String token, @PathVariable int cartID){
        if(authenticationService.isAuthenticated(token)){
            Optional<ArrayList<ProductOrder>> productOrders = Optional.of(cartService.getAllCartByOrderID(cartID).get());

            for(ProductOrder productOrder : productOrders.get()){
                productOrder.setProduct(productService.findProduct(productOrder.getProduct().getId()).get());
            }

            return ResponseEntity.of(productOrders);
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
    }

    @PostMapping
    public ResponseEntity<Object> createCart(
            @RequestHeader("Authorization") String token,
            @RequestBody Params params
    ){
        if(authenticationService.isAuthenticated(token)){

            orderService.createOrder(params.getOrder());
            Optional<ArrayList<Order>> order = orderService.getOrderNew();

            for(ProductOrder prod : params.getProductOrder()){

                prod.setOrder(new Order(order.get().stream().findFirst().get().getId()));

                productOrderService.createProductOrder(prod);
            }

            return ResponseEntity.status(HttpStatus.CREATED).body(null);
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
    }

    static class Params{
        private Order order;
        private List<ProductOrder> productOrder;

        public Params(){

        }

        public Order getOrder(){
            return order;
        }

        public List<ProductOrder> getProductOrder(){
            return productOrder;
        }

        public void setOrder(Order order) {
            this.order = order;
        }

        public void setProductOrder(List<ProductOrder> productOrder) {
            this.productOrder = productOrder;
        }
    }


}
