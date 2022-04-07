package pl.britenet.btntrainbackshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.britenet.btntrainbackshop.service.AuthenticationService;
import pl.czarek.adminpanel.obj.userOptions.User;
import pl.czarek.adminpanel.service.UserService;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin("null")
public class userController {

    private UserService userService;
    private AuthenticationService authenticationService;

    @Autowired
    public userController(UserService userService, AuthenticationService authenticationService){
        this.userService = userService;
        this.authenticationService = authenticationService;
    }

    @GetMapping
    public ResponseEntity<ArrayList<User>> getAllUsers(){
        Optional<ArrayList<User>> user = userService.findAll();
        return ResponseEntity.of(user);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable int userId){
        Optional<User> user = userService.findUser(userId);
        return ResponseEntity.of(user);
    }

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody User user, @RequestHeader("Authorization") String token){
        if(authenticationService.isAuthenticated(token)){
            userService.createUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(null);
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
    }

    @PutMapping
    public ResponseEntity<Object> updateUser(@RequestBody User user, @RequestHeader("Authorization") String token){
        if(authenticationService.isAuthenticated(token)){
            userService.updateUser(user);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Object> removeUser(@PathVariable int userId, @RequestHeader("Authorization") String token){
        if(authenticationService.isAuthenticated(token)){
            userService.removeUser(userId);
            return ResponseEntity.status(HttpStatus.GONE).body(null);
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
    }

}
