package pl.czarek.adminpanel.obj.productOrderOptions;

import pl.czarek.adminpanel.obj.Option;
import pl.czarek.adminpanel.obj.productOptions.Product;
import pl.czarek.adminpanel.service.ProductOrderService;

import java.util.ArrayList;
import java.util.Optional;

public class FindAllProductOrderOption extends Option {

    private final ProductOrderService productOrderService;

    public FindAllProductOrderOption(ProductOrderService productOrderService){
        super("findAll-productOrder");

        this.productOrderService = productOrderService;
    }

    @Override
    public void execute() {
        System.out.println("Wszystkie productOrder");

        ArrayList<ProductOrder> productOrders = this.productOrderService.findAll();
        for (ProductOrder productOrder:
                productOrders) {
            System.out.println(
                    "id: "+productOrder.getId()+", " +
                            "productID: "+productOrder.getProductID()+", " +
                            "orderID: "+productOrder.getOrderID()+", " +
                            "quantity: "+productOrder.getQuantity()+", " +
                            "price: "+productOrder.getPrice()+", " +
                            "CreateDate"+productOrder.getDate()
            );
        }
    }
}
