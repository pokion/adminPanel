package pl.czarek.adminpanel.obj.userOptions;

import pl.czarek.adminpanel.obj.Option;
import pl.czarek.adminpanel.obj.productOptions.Product;
import pl.czarek.adminpanel.service.ProductService;
import pl.czarek.adminpanel.service.UserService;

import java.util.ArrayList;
import java.util.Optional;

public class FindAllUserOption extends Option {

    private final UserService userService;

    public FindAllUserOption(UserService userService){
        super("findAll-user");

        this.userService = userService;
    }

    @Override
    public void execute() {
        System.out.println("Wszystkie user");

        Optional<ArrayList<User>> users = this.userService.findAll();

        for (User user:
                users.get()) {
            System.out.println(
                    "id: "+user.getId()+", "
                            +"login: "+ user.getLogin()+", "
                            +"name: "+user.getName()+", " +
                            "password: "+user.getPassword()+", " +
                            "createDate: "+user.getCreateDate()
            );
        }

    }
}