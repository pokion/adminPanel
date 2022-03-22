package pl.czarek.adminpanel.obj.productOrderOptions;

import pl.czarek.adminpanel.builder.ProductOrderBuilder;
import pl.czarek.adminpanel.io.input;
import pl.czarek.adminpanel.io.output;
import pl.czarek.adminpanel.obj.Option;
import pl.czarek.adminpanel.service.ProductOrderService;

public class UpdateProductOrderOption extends Option {

    private final ProductOrderService productOrderService;

    public UpdateProductOrderOption(ProductOrderService productOrderService){
        super("update-productOrder");

        this.productOrderService = productOrderService;
    }

    @Override
    public void execute() {
        output.napisz("Update productOrder");

        int id = Integer.parseInt(input.zapytanie("Podaj ID"));
        int productID = Integer.parseInt(input.zapytanie("Podaj product ID"));
        int orderID = Integer.parseInt(input.zapytanie("Podaj order ID"));
        int quantity = Integer.parseInt(input.zapytanie("Podaj quantity"));
        int price = Integer.parseInt(input.zapytanie("Podaj cenę"));

        productOrderService.updateProductOrder(new ProductOrderBuilder(id)
                .setProductID(productID)
                .setOrderID(orderID)
                .setQuantity(quantity)
                .setPrice(price)
                .getProductOrder());
    }
}
