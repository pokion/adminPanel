package pl.czarek.adminpanel.obj.orderOptions;

import pl.czarek.adminpanel.obj.Option;
import pl.czarek.adminpanel.service.OrderService;

public class FindAllOrderOption extends Option {

    private final OrderService orderService;

    public FindAllOrderOption(OrderService orderService){
        super("findAll-order");

        this.orderService = orderService;
    }

    @Override
    public void execute() {

    }
}
