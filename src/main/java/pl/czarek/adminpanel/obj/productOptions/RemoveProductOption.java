package pl.czarek.adminpanel.obj.productOptions;

import pl.czarek.adminpanel.io.input;
import pl.czarek.adminpanel.io.output;
import pl.czarek.adminpanel.obj.Option;
import pl.czarek.adminpanel.service.ProductService;

public class RemoveProductOption extends Option {

    private final ProductService productService;

    public RemoveProductOption(ProductService productService){
        super("remove-product");

        this.productService = productService;
    }

    @Override
    public void execute() {
        output.write("Usuwanie produktu");

        int id = Integer.parseInt(input.question("Podaj id"));

        productService.removeProduct(id);
    }
}
