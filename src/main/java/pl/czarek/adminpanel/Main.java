package pl.czarek.adminpanel;

import pl.czarek.adminpanel.io.input;
import pl.czarek.adminpanel.navigation.navigation;
import pl.czarek.adminpanel.obj.categoryOptions.*;
import pl.czarek.adminpanel.obj.orderOptions.*;
import pl.czarek.adminpanel.obj.productOptions.*;
import pl.czarek.adminpanel.obj.Option;
import pl.czarek.adminpanel.obj.productOrderOptions.*;
import pl.czarek.adminpanel.obj.userOptions.*;
import pl.czarek.adminpanel.service.*;

public class Main {

    private static OptionService optionService;
    private static DatabaseService databaseService;

    public static void configure() {
        databaseService = DatabaseService.getInstance();

        ProductService productService = new ProductService(databaseService);
        CategoryService categoryService = new CategoryService(databaseService);
        ProductOrderService productOrderService = new ProductOrderService(databaseService);
        UserService userService = new UserService(databaseService);
        OrderService orderService = new OrderService(databaseService);

        optionService = new OptionService();

        optionService.registerOption(new CreateOrderOption(orderService));
        optionService.registerOption(new FindOrderOption(orderService));
        optionService.registerOption(new RemoveOrderOption(orderService));
        optionService.registerOption(new UpdateOrderOption(orderService));
        optionService.registerOption(new FindAllOrderOption(orderService));

        optionService.registerOption(new CreateProductOption(productService));
        optionService.registerOption(new FindProductOption(productService));
        optionService.registerOption(new RemoveProductOption(productService));
        optionService.registerOption(new UpdateProductOption(productService));
        optionService.registerOption(new FindAllProductOption(productService));
        optionService.registerOption(new GetLinkedProductOption(productService));

        optionService.registerOption(new CreateCategoryOption(categoryService));
        optionService.registerOption(new FindCategoryOption(categoryService));
        optionService.registerOption(new RemoveCategoryOption(categoryService));
        optionService.registerOption(new UpdateCategoryOption(categoryService));
        optionService.registerOption(new FindAllCategoryOption(categoryService));

        optionService.registerOption(new CreateProductOrderOption(productOrderService));
        optionService.registerOption(new FindProductOrderOption(productOrderService));
        optionService.registerOption(new RemoveProductOrderOption(productOrderService));
        optionService.registerOption(new UpdateProductOrderOption(productOrderService));
        optionService.registerOption(new FindAllProductOrderOption(productOrderService));

        optionService.registerOption(new CreateUserOption(userService));
        optionService.registerOption(new FindUserOption(userService));
        optionService.registerOption(new RemoveUserOption(userService));
        optionService.registerOption(new UpdateUserOption(userService));
        optionService.registerOption(new FindAllUserOption(userService));
    }

    public static void main(String[] args) {
        configure();

        navigation navi = new navigation();
        navi.start(optionService);

        while (true){

            navi.showStage();
            String option = input.question("Wpisz nazwę");
            if(option.equals("exit")) navi.exit();
            navi.goTo(option);
            String nestOption = input.question("Wpisz nazwę");
            if(nestOption.equals("exit")) navi.exit();

            optionService.findOption(nestOption+"-"+navi.prevOpt)
                    .ifPresent(Option::execute);

            input.question("Press any key to continue...");
            navi.removeStage(navi.currentStage);
        }

    }

}
