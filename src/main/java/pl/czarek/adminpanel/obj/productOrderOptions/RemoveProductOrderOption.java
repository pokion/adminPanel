package pl.czarek.adminpanel.obj.productOrderOptions;

import pl.czarek.adminpanel.io.input;
import pl.czarek.adminpanel.io.output;
import pl.czarek.adminpanel.obj.Option;
import pl.czarek.adminpanel.service.ProductOrderService;

public class RemoveProductOrderOption extends Option {

    private final ProductOrderService productOrderService;

    public RemoveProductOrderOption(ProductOrderService productOrderService){
        super("remove-productOrder");

        this.productOrderService = productOrderService;
    }

    @Override
    public void execute() {
        output.write("Usuwanie productOrder");

        int id = Integer.parseInt(input.question("Podaj id"));

        productOrderService.removeProductOrder(id);
    }
}
