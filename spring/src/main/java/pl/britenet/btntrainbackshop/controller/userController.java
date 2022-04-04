package pl.britenet.btntrainbackshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.czarek.adminpanel.obj.userOptions.User;
import pl.czarek.adminpanel.service.UserService;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class userController {

    private UserService userService;

    @Autowired
    public userController(UserService userService){
        this.userService = userService;
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
    public void createUser(@RequestBody User user){
        userService.createUser(user);
    }

    @PutMapping
    public void updateUser(@RequestBody User user){
        userService.updateUser(user);
    }

    @DeleteMapping("/{userId}")
    public void removeUser(@PathVariable int userId){
        userService.removeUser(userId);
    }

}
