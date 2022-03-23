package pl.czarek.adminpanel;

import pl.czarek.adminpanel.io.input;
import pl.czarek.adminpanel.navigation.navigation;
import pl.czarek.adminpanel.obj.categoryOptions.CreateCategoryOption;
import pl.czarek.adminpanel.obj.categoryOptions.FindCategoryOption;
import pl.czarek.adminpanel.obj.categoryOptions.RemoveCategoryOption;
import pl.czarek.adminpanel.obj.categoryOptions.UpdateCategoryOption;
import pl.czarek.adminpanel.obj.orderOptions.CreateOrderOption;
import pl.czarek.adminpanel.obj.orderOptions.FindOrderOption;
import pl.czarek.adminpanel.obj.orderOptions.RemoveOrderOption;
import pl.czarek.adminpanel.obj.orderOptions.UpdateOrderOption;
import pl.czarek.adminpanel.obj.productOptions.*;
import pl.czarek.adminpanel.obj.Option;
import pl.czarek.adminpanel.obj.productOrderOptions.CreateProductOrderOption;
import pl.czarek.adminpanel.obj.productOrderOptions.FindProductOrderOption;
import pl.czarek.adminpanel.obj.productOrderOptions.RemoveProductOrderOption;
import pl.czarek.adminpanel.obj.productOrderOptions.UpdateProductOrderOption;
import pl.czarek.adminpanel.obj.userOptions.CreateUserOption;
import pl.czarek.adminpanel.obj.userOptions.FindUserOption;
import pl.czarek.adminpanel.obj.userOptions.RemoveUserOption;
import pl.czarek.adminpanel.obj.userOptions.UpdateUserOption;
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

        optionService.registerOption(new CreateProductOption(productService));
        optionService.registerOption(new FindProductOption(productService));
        optionService.registerOption(new RemoveProductOption(productService));
        optionService.registerOption(new UpdateProductOption(productService));
        optionService.registerOption(new FindAllProductOption(productService));

        optionService.registerOption(new CreateCategoryOption(categoryService));
        optionService.registerOption(new FindCategoryOption(categoryService));
        optionService.registerOption(new RemoveCategoryOption(categoryService));
        optionService.registerOption(new UpdateCategoryOption(categoryService));

        optionService.registerOption(new CreateProductOrderOption(productOrderService));
        optionService.registerOption(new FindProductOrderOption(productOrderService));
        optionService.registerOption(new RemoveProductOrderOption(productOrderService));
        optionService.registerOption(new UpdateProductOrderOption(productOrderService));

        optionService.registerOption(new CreateUserOption(userService));
        optionService.registerOption(new FindUserOption(userService));
        optionService.registerOption(new RemoveUserOption(userService));
        optionService.registerOption(new UpdateUserOption(userService));
    }

    public static void main(String[] args) {
        configure();

        navigation navi = new navigation();
        navi.start(optionService);

        while (true){

            navi.showStage();
            String option = input.zapytanie("Wpisz nazwę");
            if(option.equals("exit")) navi.exit();
            navi.goTo(option);
            String nestOption = input.zapytanie("Wpisz nazwę");
            if(nestOption.equals("exit")) navi.exit();

            optionService.findOption(nestOption+"-"+navi.prevOpt)
                    .ifPresent(Option::execute);

            input.zapytanie("Press any key to continue...");
            navi.removeStage(navi.currentStage);
        }

    }

}
