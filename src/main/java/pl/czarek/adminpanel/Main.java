package pl.czarek.adminpanel;

import pl.czarek.adminpanel.io.input;
import pl.czarek.adminpanel.io.output;
import pl.czarek.adminpanel.navigation.navigation;
import pl.czarek.adminpanel.obj.cartOption.CreateCartOption;
import pl.czarek.adminpanel.obj.cartOption.FindCartOption;
import pl.czarek.adminpanel.obj.cartOption.RemoveCartOption;
import pl.czarek.adminpanel.obj.cartOption.UpdateCartOption;
import pl.czarek.adminpanel.obj.categoryOptions.CreateCategoryOption;
import pl.czarek.adminpanel.obj.categoryOptions.FindCategoryOption;
import pl.czarek.adminpanel.obj.categoryOptions.RemoveCategoryOption;
import pl.czarek.adminpanel.obj.categoryOptions.UpdateCategoryOption;
import pl.czarek.adminpanel.obj.productOptions.CreateProductOption;
import pl.czarek.adminpanel.obj.Option;
import pl.czarek.adminpanel.obj.productOptions.FindProductOption;
import pl.czarek.adminpanel.obj.productOptions.RemoveProductOption;
import pl.czarek.adminpanel.obj.productOptions.UpdateProductOption;
import pl.czarek.adminpanel.obj.userOption.CreateUserOption;
import pl.czarek.adminpanel.obj.userOption.FindUserOption;
import pl.czarek.adminpanel.obj.userOption.RemoveUserOption;
import pl.czarek.adminpanel.obj.userOption.UpdateUserOption;
import pl.czarek.adminpanel.service.*;

public class Main {

    private static OptionService optionService;

    public static void configure() {
        ProductService productService = new ProductService();
        CategoryService categoryService = new CategoryService();
        CartService cartService = new CartService();
        UserService userService = new UserService();

        optionService = new OptionService();
        optionService.registerOption(new CreateProductOption(productService));
        optionService.registerOption(new FindProductOption(productService));
        optionService.registerOption(new RemoveProductOption(productService));
        optionService.registerOption(new UpdateProductOption(productService));

        optionService.registerOption(new CreateCategoryOption(categoryService));
        optionService.registerOption(new FindCategoryOption(categoryService));
        optionService.registerOption(new RemoveCategoryOption(categoryService));
        optionService.registerOption(new UpdateCategoryOption(categoryService));

        optionService.registerOption(new CreateCartOption(cartService));
        optionService.registerOption(new FindCartOption(cartService));
        optionService.registerOption(new RemoveCartOption(cartService));
        optionService.registerOption(new UpdateCartOption(cartService));

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

            navi.removeStage(navi.currentStage);
        }

    }

}
