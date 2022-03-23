package pl.czarek.adminpanel.obj.productOptions;

import pl.czarek.adminpanel.io.output;
import pl.czarek.adminpanel.obj.Option;
import pl.czarek.adminpanel.service.ProductService;

import java.util.ArrayList;
import java.util.Optional;

public class FindAllProductOption extends Option {

    private final ProductService productService;

    public FindAllProductOption(ProductService productService){
        super("findAll-product");

        this.productService = productService;
    }

    @Override
    public void execute() {
        System.out.println("Wszystkie produkty");

        Optional<ArrayList<Product>> products = this.productService.findAll();

        for (Product product:
        products.get()) {
            System.out.println(
                    "id: "+product.getId()+", "
                    +"categoryID: "+product.getCategoryID()+", "
                    +"name: "+product.getName()
            );
        }

    }
}
