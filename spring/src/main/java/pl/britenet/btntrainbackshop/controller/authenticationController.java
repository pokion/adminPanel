package pl.britenet.btntrainbackshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.britenet.btntrainbackshop.service.AuthenticationService;
import pl.czarek.adminpanel.obj.userOptions.User;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/authenticate")
@CrossOrigin("null")
public class authenticationController {

    private final AuthenticationService authenticationService;

    @Autowired
    public authenticationController(AuthenticationService authenticationService){
        this.authenticationService = authenticationService;
    }

    @PostMapping
    public Map<String , Object> authenticate(@RequestBody Map<String , Object> body){
        String login = (String) body.get("login");
        String password = (String) body.get("password");

        return this.authenticationService.authenticate(login,password);
    }

    @GetMapping
    public Optional<User> retriveByToken(@RequestBody String token){
        return Optional.of(this.authenticationService.retrieveUserByToken(token).orElseThrow());
    }

}
