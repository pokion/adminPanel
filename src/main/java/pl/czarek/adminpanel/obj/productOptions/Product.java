package pl.czarek.adminpanel.obj.productOptions;

import pl.czarek.adminpanel.obj.categoryOptions.Category;

public class Product {

    private int id;
    private String name;
    private float price;
    private Category category;
    private String images;
    private String sex;
    private String brand;
    private String color;
    private String model;
    private String style;

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

    public String getStyle(){
        return style;
    }

    public String getModel(){
        return model;
    }

    public String getColor(){
        return color;
    }

    public String  getBrand(){
        return brand;
    }

    public String  getSex(){
        return sex;
    }

    public float getPrice(){
        return price;
    }

    public void setStyle(String style){
        this.style = style;
    }

    public void setModel(String model){
        this.model = model;
    }

    public void setColor(String color){
        this.color = color;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }

    public void setSex(String sex){
        this.sex = sex;
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
