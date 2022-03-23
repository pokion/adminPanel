package pl.czarek.adminpanel.obj.orderOptions;

import pl.czarek.adminpanel.builder.OrderBuilder;
import pl.czarek.adminpanel.io.input;
import pl.czarek.adminpanel.io.output;
import pl.czarek.adminpanel.obj.Option;
import pl.czarek.adminpanel.service.OrderService;

public class CreateOrderOption extends Option {

    private final OrderService orderService;

    public CreateOrderOption(OrderService orderService){
        super("create-order");

        this.orderService = orderService;
    }

    @Override
    public void execute() {
        output.napisz("Tworzenie order");

        int userID = Integer.parseInt(input.zapytanie("Podaj userID"));
        String status = input.zapytanie("Podaj status");

        orderService.createOrder(new OrderBuilder()
                .setUserID(userID)
                .setStatus(status)
                .getOrder());
    }
}