package pl.czarek.adminpanel;

import pl.czarek.adminpanel.obj.CreateProductOption;
import pl.czarek.adminpanel.obj.Option;
import pl.czarek.adminpanel.service.OptionService;
import pl.czarek.adminpanel.service.ProductService;

public class Main {

    private static OptionService optionService;

    public static void configure() {
        ProductService productService = new ProductService();

        optionService = new OptionService();
        optionService.registerOption(new CreateProductOption(productService));
    }

    public static void main(String[] args) {
        configure();

        optionService.findOption("create-product")
                .ifPresent(Option::execute);
    }

}
