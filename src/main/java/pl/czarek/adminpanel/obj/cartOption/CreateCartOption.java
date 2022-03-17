package pl.czarek.adminpanel.obj.cartOption;

import pl.czarek.adminpanel.builder.CartBuilder;
import pl.czarek.adminpanel.io.input;
import pl.czarek.adminpanel.io.output;
import pl.czarek.adminpanel.obj.Option;
import pl.czarek.adminpanel.service.CartService;

public class CreateCartOption extends Option {

    private final CartService cartService;

    public CreateCartOption(CartService cartService){
        super("create-cart");

        this.cartService = cartService;
    }

    @Override
    public void execute() {
        output.napisz("Tworzenie cart" + "\n");

        int id = Integer.parseInt(input.zapytanie("Podaj id"));
        String listProduct = input.zapytanie("Podaj produkt");
        int userID = Integer.parseInt(input.zapytanie("Podaj userID"));
        String status = input.zapytanie("Podaj status");

        cartService.createCart(new CartBuilder(id)
                .setListProduct(listProduct)
                .setUserID(userID)
                .setStatus(status).getCart());
    }
}
