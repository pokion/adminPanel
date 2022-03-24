package pl.czarek.adminpanel.obj.orderOptions;

import pl.czarek.adminpanel.io.input;
import pl.czarek.adminpanel.io.output;
import pl.czarek.adminpanel.obj.Option;
import pl.czarek.adminpanel.service.OrderService;

public class RemoveOrderOption extends Option {

    private final OrderService orderService;

    public RemoveOrderOption(OrderService orderService){
        super("remove-order");

        this.orderService = orderService;
    }

    @Override
    public void execute() {
        output.write("Usuwanie order");

        int id = Integer.parseInt(input.question("Podaj id"));

        orderService.removeOrder(id);
    }
}
