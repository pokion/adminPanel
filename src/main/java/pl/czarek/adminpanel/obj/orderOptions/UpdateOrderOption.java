package pl.czarek.adminpanel.obj.orderOptions;

import pl.czarek.adminpanel.builder.OrderBuilder;
import pl.czarek.adminpanel.io.input;
import pl.czarek.adminpanel.io.output;
import pl.czarek.adminpanel.obj.Option;
import pl.czarek.adminpanel.service.OrderService;

public class UpdateOrderOption extends Option {

    private final OrderService orderService;

    public UpdateOrderOption(OrderService orderService){
        super("update-order");

        this.orderService = orderService;
    }

    @Override
    public void execute() {
        output.napisz("Update order");

        int id = Integer.parseInt(input.zapytanie("Podaj ID"));
        int userID = Integer.parseInt(input.zapytanie("Podaj user ID"));
        String status = input.zapytanie("Podaj status");

        orderService.updateOrder(new OrderBuilder(id)
                .setUserID(userID)
                .setStatus(status)
                .getOrder());
    }
}
