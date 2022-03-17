package pl.czarek.adminpanel.obj.userOption;

import pl.czarek.adminpanel.builder.UserBuilder;
import pl.czarek.adminpanel.io.input;
import pl.czarek.adminpanel.io.output;
import pl.czarek.adminpanel.obj.Option;
import pl.czarek.adminpanel.service.UserService;

public class CreateUserOption extends Option {

    private final UserService userService;

    public CreateUserOption(UserService userService){
        super("create-user");

        this.userService = userService;
    }

    @Override
    public void execute() {
        output.napisz("Tworzenie user" + "\n");

        int id = Integer.parseInt(input.zapytanie("Podaj id"));
        String name = input.zapytanie("podaj nazwę");
        String login = input.zapytanie("podaj login");
        String password = input.zapytanie("podaj hasło");

        userService.createUser(new UserBuilder(id)
                .setName(name)
                .setLogin(login)
                .setPassword(password)
                .getUser());
    }
}
