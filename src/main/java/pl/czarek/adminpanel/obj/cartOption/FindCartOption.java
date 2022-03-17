package pl.czarek.adminpanel.obj.cartOption;

import pl.czarek.adminpanel.io.input;
import pl.czarek.adminpanel.io.output;
import pl.czarek.adminpanel.obj.Option;
import pl.czarek.adminpanel.service.CartService;

import java.util.Optional;

public class FindCartOption extends Option {

    private final CartService cartService;

    public FindCartOption(CartService cartService){
        super("find-cart");

        this.cartService = cartService;
    }


    @Override
    public void execute() {
        output.napisz("Szukanie koszykow");

        int id = Integer.parseInt(input.zapytanie("Podaj id"));

        Optional<Cart> cart = cartService.findCart(id);
        output.napisz("status" + cart.get().getStatus());
        output.napisz("userID " + cart.get().getUserID());
        output.napisz("produkty " + cart.get().getListProduct());
    }
}
