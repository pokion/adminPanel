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

    public ProductBuilder setStyle(String style){
        this.product.setStyle(style);
        return this;
    }

    public ProductBuilder setModel(String model){
        this.product.setModel(model);
        return this;
    }

    public ProductBuilder setColor(String color){
        this.product.setColor(color);
        return this;
    }

    public ProductBuilder setBrand(String brand){
        this.product.setBrand(brand);
        return this;
    }

    public ProductBuilder setSex(String sex){
        this.product.setSex(sex);
        return this;
    }

    public ProductBuilder setCategory(Category category){
        this.product.setCategory(category);
        return this;
    }

    public Product getProduct(){
        return this.product;
    }

    public ProductBuilder setPrice(float price) {
        this.product.setPrice(price);
        return this;
    }

    public ProductBuilder setPath(String path) {
        this.product.setImages(path);
        return this;
    }
}
