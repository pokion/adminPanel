package pl.czarek.adminpanel.obj.productOrderOptions;

import pl.czarek.adminpanel.builder.ProductOrderBuilder;
import pl.czarek.adminpanel.io.input;
import pl.czarek.adminpanel.io.output;
import pl.czarek.adminpanel.obj.Option;
import pl.czarek.adminpanel.service.ProductOrderService;

public class CreateProductOrderOption extends Option {

    private final ProductOrderService productOrderService;

    public CreateProductOrderOption(ProductOrderService productOrderService){
        super("create-productOrder");

        this.productOrderService = productOrderService;
    }

    @Override
    public void execute() {
        output.write("Tworzenie productOrder");

        int productID = Integer.parseInt(input.question("Podaj product ID"));
        int orderID = Integer.parseInt(input.question("Podaj order ID"));
        int quantity = Integer.parseInt(input.question("Podaj quantity"));
        float price = Float.parseFloat(input.question("Podaj cenę"));

        productOrderService.createProductOrder(new ProductOrderBuilder()
                .setProductID(productID)
                .setOrderID(orderID)
                .setQuantity(quantity)
                .setPrice(price)
                .getProductOrder());
    }
}
