package pl.czarek.adminpanel.obj.userOptions;

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
        output.write("Tworzenie user" + "\n");

        String name = input.question("podaj nazwę");
        String login = input.question("podaj login");
        String password = input.question("podaj hasło");

        userService.createUser(new UserBuilder()
                .setName(name)
                .setLogin(login)
                .setPassword(password)
                .getUser());
    }
}
