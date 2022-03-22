package pl.czarek.adminpanel.obj.orderOptions;

import com.sun.source.tree.IfTree;
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
        output.napisz("Find order");

        int id = Integer.parseInt(input.zapytanie("Podaj ID"));

        Optional<Order> order = orderService.findOrder(id);

        if (order.isPresent()){
            output.napisz("id: "+order.get().getId());
            output.napisz("userID: "+order.get().getUserID());
            output.napisz("status: "+order.get().getStatus());
            output.napisz("date: "+order.get().getDate());
        }else {
            output.napisz("Nie znaleziono");
        }
    }
}
