package pl.czarek.adminpanel.obj.orderOptions;

import pl.czarek.adminpanel.io.input;
import pl.czarek.adminpanel.io.output;
import pl.czarek.adminpanel.obj.Option;
import pl.czarek.adminpanel.service.OrderService;

import java.util.Optional;

public class FindOrderOption extends Option {

    private final OrderService orderService;

    public FindOrderOption(OrderService orderService){
        super("find-order");

        this.orderService = orderService;
    }

    @Override
    public void execute() {
        output.write("Find order");

        int id = Integer.parseInt(input.question("Podaj ID"));

        Optional<Order> order = orderService.findOrder(id);

        if (order.isPresent()){
            output.write("id: "+order.get().getId());
            output.write("userID: "+order.get().getUser().getId());
            output.write("status: "+order.get().getStatus());
            output.write("date: "+order.get().getDate());
        }else {
            output.write("Nie znaleziono");
        }
    }
}
