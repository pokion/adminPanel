package pl.czarek.adminpanel.obj.userOption;

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
        output.napisz(user.get().getName());
    }
}
