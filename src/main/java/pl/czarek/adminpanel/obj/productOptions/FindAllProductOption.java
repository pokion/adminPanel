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
        output.napisz("Wszystkie produkty");

        Optional<ArrayList<Product>> products = this.productService.findAll();

        for (Product product:
        products.get()) {

        }
        System.out.println();
//        for (int i=0;i<products.get().size(); i++){
//            output.napisz("id: "+products.get().get(i).getId()+
//                    ", categoryID: "+products.get().get(i).getCategoryID()+
//                    ", name: "+products.get().get(i).getName());
//        }

    }
}
