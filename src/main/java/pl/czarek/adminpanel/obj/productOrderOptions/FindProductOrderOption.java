package pl.czarek.adminpanel.obj.productOrderOptions;

import pl.czarek.adminpanel.io.input;
import pl.czarek.adminpanel.io.output;
import pl.czarek.adminpanel.obj.Option;
import pl.czarek.adminpanel.service.ProductOrderService;

import java.util.Optional;

public class FindProductOrderOption extends Option {

    private final ProductOrderService productOrderService;

    public FindProductOrderOption(ProductOrderService productOrderService){
        super("find-productOrder");

        this.productOrderService = productOrderService;
    }

    @Override
    public void execute() {
        output.write("Find productOrder");

        int id = Integer.parseInt(input.question("Podaj ID"));

        Optional<ProductOrder> productOrder = productOrderService.findProductOrder(id);

        if (productOrder.isPresent()){
            output.write("id: "+productOrder.get().getId());
            output.write("productID: "+productOrder.get().getProductID());
            output.write("orderID: "+productOrder.get().getOrderID());
            output.write("quantity: "+productOrder.get().getQuantity());
            output.write("price: "+productOrder.get().getPrice());
            output.write("createDate: "+productOrder.get().getDate());
        }else {
            output.write("Nie znaleziono");
        }
    }
}
