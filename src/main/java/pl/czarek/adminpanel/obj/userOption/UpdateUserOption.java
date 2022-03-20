package pl.czarek.adminpanel.obj.userOption;

import pl.czarek.adminpanel.io.input;
import pl.czarek.adminpanel.io.output;
import pl.czarek.adminpanel.obj.Option;
import pl.czarek.adminpanel.service.UserService;

public class UpdateUserOption extends Option {

    private final UserService userService;

    public UpdateUserOption(UserService userService){
        super("update-user");

        this.userService = userService;
    }

    @Override
    public void execute() {
        output.napisz("aktualizacja user");

        int id = Integer.parseInt(input.zapytanie("Podaj id"));

        String name = input.zapytanie("Podaj imię");
        String login = input.zapytanie("Podaj login");
        String password = input.zapytanie("Podaj hasło");

        userService.updateUser(new User(id, name,login, password));
    }
}
