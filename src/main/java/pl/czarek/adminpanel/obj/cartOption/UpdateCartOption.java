package pl.czarek.adminpanel.obj.cartOption;

import pl.czarek.adminpanel.io.input;
import pl.czarek.adminpanel.io.output;
import pl.czarek.adminpanel.obj.Option;
import pl.czarek.adminpanel.service.CartService;

public class UpdateCartOption extends Option {

    private final CartService cartService;

    public UpdateCartOption(CartService cartService){
        super("update-cart");

        this.cartService = cartService;
    }

    @Override
    public void execute() {
        output.napisz("Usuwanie koszyka");

        int id = Integer.parseInt(input.zapytanie("Podaj id"));

        cartService.removeCart(id);
    }
}
