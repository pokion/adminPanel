package pl.czarek.adminpanel.obj.productOptions;

import pl.czarek.adminpanel.io.input;
import pl.czarek.adminpanel.io.output;
import pl.czarek.adminpanel.obj.Option;
import pl.czarek.adminpanel.service.ProductService;

public class CreateProductOption extends Option {

    private final ProductService productService;

    public CreateProductOption(ProductService productService) {
        super("create-product");

        this.productService = productService;
    }

    @Override
    public void execute() {
        output.napisz("Tworzenie produktu");

        int id = Integer.parseInt(input.zapytanie("Podaj id"));
        String name = input.zapytanie("Podaj nazwę");
        int categoryID = Integer.parseInt(input.zapytanie("Podaj id kategorii"));


        productService.createProduct(id, name, categoryID);
    }

}
