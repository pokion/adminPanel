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
        output.napisz("Find productOrder");

        int id = Integer.parseInt(input.zapytanie("Podaj ID"));

        Optional<ProductOrder> productOrder = productOrderService.findProductOrder(id);

        if (productOrder.isPresent()){
            output.napisz("id: "+productOrder.get().getId());
            output.napisz("productID: "+productOrder.get().getProductID());
            output.napisz("orderID: "+productOrder.get().getOrderID());
            output.napisz("quantity: "+productOrder.get().getQuantity());
            output.napisz("price: "+productOrder.get().getPrice());
            output.napisz("createDate: "+productOrder.get().getDate());
        }else {
            output.napisz("Nie znaleziono");
        }
    }
}
