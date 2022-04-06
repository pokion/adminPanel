package pl.czarek.adminpanel.obj.productOptions;

import pl.czarek.adminpanel.obj.categoryOptions.Category;

public class Product {

    private int id;
    private String name;
    private float price;
    private Category category;
    private String images;

    public Product(){}

    public Product(int id){
        this.id = id;
    }

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public float getPrice(){
        return price;
    }

    public String getImages(){
        return images;
    }

    public String getName() {
        return name;
    }

    public Category getCategory(){
        return category;
    }

    public void setImages(String images){
        this.images = images;
    }

    public void setCategory(Category category){
        this.category = category;
    }

    public void setPrice(float price){
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

}
