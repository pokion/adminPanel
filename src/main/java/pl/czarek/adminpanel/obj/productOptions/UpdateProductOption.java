package pl.czarek.adminpanel.obj.productOptions;

import pl.czarek.adminpanel.builder.ProductBuilder;
import pl.czarek.adminpanel.io.input;
import pl.czarek.adminpanel.io.output;
import pl.czarek.adminpanel.obj.Option;
import pl.czarek.adminpanel.obj.categoryOptions.Category;
import pl.czarek.adminpanel.service.ProductService;

public class UpdateProductOption extends Option {

    private final ProductService productService;

    public UpdateProductOption(ProductService productService){
        super("update-product");

        this.productService = productService;
    }

    @Override
    public void execute() {
        output.write("Aktualizacja produktu");

        int id = Integer.parseInt(input.question("Podaj id"));
        String name = input.question("Podaj nazwę");
        int categoryId = Integer.parseInt(input.question("Podaj idkategorii"));

        productService.updateProduct(new ProductBuilder(id)
                .setName(name)
                .setCategory(new Category(categoryId))
                .getProduct());
    }
}
