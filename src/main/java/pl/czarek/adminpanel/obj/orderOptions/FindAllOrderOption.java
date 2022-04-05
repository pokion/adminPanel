package pl.czarek.adminpanel.obj.orderOptions;

import pl.czarek.adminpanel.obj.Option;
import pl.czarek.adminpanel.obj.productOptions.Product;
import pl.czarek.adminpanel.service.OrderService;

import java.util.ArrayList;
import java.util.Optional;

public class FindAllOrderOption extends Option {

    private final OrderService orderService;

    public FindAllOrderOption(OrderService orderService){
        super("findAll-order");

        this.orderService = orderService;
    }

    @Override
    public void execute() {
        System.out.println("Wszystkie order");

        Optional<ArrayList<Order>> orders = this.orderService.findAll();

        for (Order order:
                orders.get()) {
            System.out.println(
                    "id: "+order.getId()+", " +
                            "date: "+order.getDate()+", " +
                            "status: "+order.getStatus()+", " +
                            "user: "+order.getUser().getId()
            );
        }
    }
}
