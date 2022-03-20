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
        output.napisz("Aktualizacja koszyka");

        int id = Integer.parseInt(input.zapytanie("Podaj id"));
        String listProduct = input.zapytanie("Podaj listę produktów");
        int userID = Integer.parseInt(input.zapytanie("Podaj id user"));
        String status = input.zapytanie("Podaj status");

        cartService.updateCart(new Cart(id, listProduct, userID, status));
    }
}
