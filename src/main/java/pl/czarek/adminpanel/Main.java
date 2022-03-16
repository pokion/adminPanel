package pl.czarek.adminpanel;

import pl.czarek.adminpanel.io.input;
import pl.czarek.adminpanel.io.output;
import pl.czarek.adminpanel.navigation.navigation;
import pl.czarek.adminpanel.obj.categoryOptions.CreateCategoryOption;
import pl.czarek.adminpanel.obj.categoryOptions.FindCategoryOption;
import pl.czarek.adminpanel.obj.categoryOptions.RemoveCategoryOption;
import pl.czarek.adminpanel.obj.categoryOptions.UpdateCategoryOption;
import pl.czarek.adminpanel.obj.productOptions.CreateProductOption;
import pl.czarek.adminpanel.obj.Option;
import pl.czarek.adminpanel.obj.productOptions.FindProductOption;
import pl.czarek.adminpanel.obj.productOptions.RemoveProductOption;
import pl.czarek.adminpanel.obj.productOptions.UpdateProductOption;
import pl.czarek.adminpanel.service.CategoryService;
import pl.czarek.adminpanel.service.OptionService;
import pl.czarek.adminpanel.service.ProductService;

public class Main {

    private static OptionService optionService;

    public static void configure() {
        ProductService productService = new ProductService();
        CategoryService categoryService = new CategoryService();

        optionService = new OptionService();
        optionService.registerOption(new CreateProductOption(productService));
        optionService.registerOption(new FindProductOption(productService));
        optionService.registerOption(new RemoveProductOption(productService));
        optionService.registerOption(new UpdateProductOption(productService));

        optionService.registerOption(new CreateCategoryOption(categoryService));
        optionService.registerOption(new FindCategoryOption(categoryService));
        optionService.registerOption(new RemoveCategoryOption(categoryService));
        optionService.registerOption(new UpdateCategoryOption(categoryService));
    }

    public static void main(String[] args) {
        configure();

        navigation navi = new navigation();

        navi.start(optionService);

        navi.showStage();

        String res = input.zapytanie("Wpisz nazwę");

        navi.goTo(res.split("\n")[0]);

    }

}
