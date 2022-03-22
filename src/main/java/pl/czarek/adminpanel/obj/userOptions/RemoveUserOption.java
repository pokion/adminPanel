package pl.czarek.adminpanel.obj.userOptions;

import pl.czarek.adminpanel.io.input;
import pl.czarek.adminpanel.io.output;
import pl.czarek.adminpanel.obj.Option;
import pl.czarek.adminpanel.service.UserService;

public class RemoveUserOption extends Option {

    private final UserService userService;

    public RemoveUserOption(UserService userService){
        super("remove-user");

        this.userService = userService;
    }

    @Override
    public void execute() {
        output.napisz("Usuwanie user");

        int id = Integer.parseInt(input.zapytanie("Podaj id"));

        userService.removeUser(id);
    }
}
