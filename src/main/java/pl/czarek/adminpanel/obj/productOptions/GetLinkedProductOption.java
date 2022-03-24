package pl.czarek.adminpanel.obj.productOptions;

import pl.czarek.adminpanel.io.output;
import pl.czarek.adminpanel.obj.Option;
import pl.czarek.adminpanel.service.ProductService;

import java.util.ArrayList;

public class GetLinkedProductOption extends Option {

    private final ProductService productService;

    public GetLinkedProductOption(ProductService productService){
        super("getLinked-product");

        this.productService = productService;
    }

    @Override
    public void execute() {
        output.write("getLinked product");

        ArrayList<Product> products = productService.getLinked();

        for (Product product:
             products) {
            output.write("id: "+product.getId()+", " +
                    "name: "+product.getName()+", " +
                    "categoryID: "+product.getCategory().getId()+", " +
                    "category name: "+product.getCategory().getName());
        }
    }
}
