package pl.czarek.adminpanel.service;

import pl.czarek.adminpanel.obj.productOptions.Product;

import java.util.*;

public class ProductService {

    private final Map<Integer, Product> products;

    public ProductService() {
        this.products = new HashMap<>();
    }

    public void createProduct(Product product) {
        this.products.put(product.getId(), product);
    }

    public void updateProduct(int id, String name, int categoryID) {
        this.products.get(id).setName(name);
        this.products.get(id).setCategoryID(categoryID);
    }

    public Optional<Product> findProduct(int id) {
        return Optional.of(this.products.get(id));
    }

    public void removeProduct(int id) {
        this.products.remove(id);
    }
}
