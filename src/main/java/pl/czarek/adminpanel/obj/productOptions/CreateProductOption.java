package pl.czarek.adminpanel.obj.productOptions;

import pl.czarek.adminpanel.builder.ProductBuilder;
import pl.czarek.adminpanel.io.input;
import pl.czarek.adminpanel.io.output;
import pl.czarek.adminpanel.obj.Option;
import pl.czarek.adminpanel.obj.categoryOptions.Category;
import pl.czarek.adminpanel.service.ProductService;

public class CreateProductOption extends Option {

    private final ProductService productService;

    public CreateProductOption(ProductService productService) {
        super("create-product");

        this.productService = productService;
    }

    @Override
    public void execute() {
        output.write("Tworzenie produktu");

        String name = input.question("Podaj nazwę");
        int categoryID = Integer.parseInt(input.question("Podaj id kategorii"));


        productService.createProduct(new ProductBuilder()
                .setName(name)
                .setCategory(new Category(categoryID))
                .getProduct());
    }

}
