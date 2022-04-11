package pl.britenet.btntrainbackshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.britenet.btntrainbackshop.service.AuthenticationService;
import pl.czarek.adminpanel.obj.cart.Cart;
import pl.czarek.adminpanel.obj.userOptions.User;
import pl.czarek.adminpanel.service.CartService;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/cart")
@CrossOrigin("null")
public class cartController {

    private CartService cartService;
    private AuthenticationService authenticationService;

    @Autowired
    public cartController(CartService cartService, AuthenticationService authenticationService){
        this.authenticationService = authenticationService;
        this.cartService = cartService;
    }

    @GetMapping
    public ResponseEntity<ArrayList<Cart>> getCarts(@RequestHeader("Authorization") String token){
        if(authenticationService.isAuthenticated(token)){
            Optional<User> user = authenticationService.retrieveUserByToken(token);
            Optional<ArrayList<Cart>> carts =  cartService.getAllCart(user.get().getId());
            return  ResponseEntity.of(carts);
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
    }


}
