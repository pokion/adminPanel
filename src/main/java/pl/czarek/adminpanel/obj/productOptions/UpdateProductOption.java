package pl.czarek.adminpanel.obj.productOptions;

import pl.czarek.adminpanel.io.input;
import pl.czarek.adminpanel.io.output;
import pl.czarek.adminpanel.obj.Option;
import pl.czarek.adminpanel.service.ProductService;

public class UpdateProductOption extends Option {

    private final ProductService productService;

    public UpdateProductOption(ProductService productService){
        super("update-product");

        this.productService = productService;
    }

    @Override
    public void execute() {
        output.napisz("Aktualizacja produktu");

        int id = Integer.parseInt(input.zapytanie("Podaj id"));
        String name = input.zapytanie("Podaj nazwę");

        productService.updateProduct(id, name);
    }
}
