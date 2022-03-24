package pl.czarek.adminpanel.obj.userOptions;

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
        output.write("aktualizacja user");

        int id = Integer.parseInt(input.question("Podaj id"));

        String name = input.question("Podaj imię");
        String login = input.question("Podaj login");
        String password = input.question("Podaj hasło");

        userService.updateUser(new User(id, name,login, password));
    }
}
