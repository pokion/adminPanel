package pl.czarek.adminpanel.obj.productOrderOptions;

import pl.czarek.adminpanel.builder.OrderBuilder;
import pl.czarek.adminpanel.builder.ProductBuilder;
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
        output.write("Update productOrder");

        int id = Integer.parseInt(input.question("Podaj ID"));
        int productID = Integer.parseInt(input.question("Podaj product ID"));
        int orderID = Integer.parseInt(input.question("Podaj order ID"));
        int quantity = Integer.parseInt(input.question("Podaj quantity"));
        float price = Float.parseFloat(input.question("Podaj cenę"));

        productOrderService.updateProductOrder(new ProductOrderBuilder(id)
                .setProduct(new ProductBuilder(productID).getProduct())
                .setOrder(new OrderBuilder(orderID).getOrder())
                .setQuantity(quantity)
                .setPrice(price)
                .getProductOrder());
    }
}
