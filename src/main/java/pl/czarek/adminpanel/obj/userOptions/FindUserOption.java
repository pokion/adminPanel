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
        output.napisz("Szukanie usera");

        int id = Integer.parseInt(input.zapytanie("Podaj id"));

        Optional<User> user = userService.findUser(id);
        if (user.isPresent()){
            output.napisz("id: "+ user.get().getId());
            output.napisz("name: "+ user.get().getName());
            output.napisz("login: "+ user.get().getLogin());
            output.napisz("password: "+ user.get().getPassword());
        }else {
            output.napisz("Nie znaleziono");
        }
    }
}
