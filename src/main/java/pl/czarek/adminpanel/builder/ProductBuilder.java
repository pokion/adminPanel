package pl.czarek.adminpanel.builder;

import pl.czarek.adminpanel.obj.categoryOptions.Category;
import pl.czarek.adminpanel.obj.productOptions.Product;

public class ProductBuilder {

    private final Product product;

    public ProductBuilder(){
        this.product = new Product();
    }

    public ProductBuilder(int id){
        this.product = new Product(id);
    }

    public ProductBuilder setName(String name){
        this.product.setName(name);
        return this;
    }

    public ProductBuilder setCategory(Category category){
        this.product.setCategory(category);
        return this;
    }

    public Product getProduct(){
        return this.product;
    }
}
