package pl.czarek.adminpanel.service;

import pl.czarek.adminpanel.obj.productOptions.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductService {

    private final List<Product> products;

    public ProductService() {
        this.products = new ArrayList<>();
    }

    public void createProduct(int id, String name, int categoryID) {
        this.products.add(new Product(id, name, categoryID));
    }

    public void updateProduct(int id, String name) {
        this.products.stream()
                .filter( product -> product.getId() == id )
                .findFirst()
                .ifPresent( product -> product.setName(name) );
    }

    public Optional<Product> findProduct(int id) {
        return this.products.stream()
                .filter( product -> product.getId() == id )
                .findFirst();
    }

    public void removeProduct(int id) {
        this.products.removeIf( product -> product.getId() == id );
    }
}
