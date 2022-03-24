package pl.czarek.adminpanel.obj.productOptions;

import pl.czarek.adminpanel.io.input;
import pl.czarek.adminpanel.io.output;
import pl.czarek.adminpanel.obj.Option;
import pl.czarek.adminpanel.service.ProductService;

import java.util.Optional;

public class FindProductOption extends Option {

    private final ProductService productService;

    public FindProductOption(ProductService productService){
        super("find-product");

        this.productService = productService;
    }

    @Override
    public void execute() {
        output.write("Szukanie produktu");

        int id = Integer.parseInt(input.question("Podaj id"));

        Optional<Product> product = productService.findProduct(id);
        if (product.isPresent()){
            output.write("id: "+product.get().getId());
            output.write("categoryID: "+product.get().getCategory().getId());
            output.write("name: "+product.get().getName());
        }else {
            output.write("nie znaleziono");
        }
    }
}
