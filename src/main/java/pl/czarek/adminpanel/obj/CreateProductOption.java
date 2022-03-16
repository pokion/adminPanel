package pl.czarek.adminpanel.obj;

import pl.czarek.adminpanel.service.ProductService;

public class CreateProductOption extends Option {

    private final ProductService productService;

    public CreateProductOption(ProductService productService) {
        super("create-product");

        this.productService = productService;
    }

    @Override
    public void execute() {
        productService.createProduct(1, "Test");

        productService.findProduct(1)
                .ifPresent( product -> {
                    System.out.println("Produkt: " + product.getName());
                } );
    }

}
