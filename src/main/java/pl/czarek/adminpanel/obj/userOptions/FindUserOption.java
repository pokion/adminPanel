package pl.czarek.adminpanel.obj.userOptions;

import pl.czarek.adminpanel.io.input;
import pl.czarek.adminpanel.io.output;
import pl.czarek.adminpanel.obj.Option;
import pl.czarek.adminpanel.service.UserService;

import java.util.Optional;

public class FindUserOption extends Option {

    private final UserService userService;

    public FindUserOption findUserOption;

    public FindUserOption(UserService userService){
        super("find-user");

        this.userService = userService;
    }

    @Override
    public void execute() {
        output.write("Szukanie usera");

        int id = Integer.parseInt(input.question("Podaj id"));

        Optional<User> user = userService.findUser(id);
        if (user.isPresent()){
            output.write("id: "+ user.get().getId());
            output.write("name: "+ user.get().getName());
            output.write("login: "+ user.get().getLogin());
            output.write("password: "+ user.get().getPassword());
        }else {
            output.write("Nie znaleziono");
        }
    }
}
