package pl.czarek.adminpanel.obj.productOptions;

import pl.czarek.adminpanel.obj.categoryOptions.Category;

public class Product {

    private int id;
    private String name;
    private Category category;

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


    public String getName() {
        return name;
    }

    public Category getCategory(){
        return category;
    }

    public void setCategory(Category category){
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

}
