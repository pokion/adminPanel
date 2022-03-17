package pl.czarek.adminpanel.obj.productOptions;

public class Product {

    private final int id;
    private int categoryID;
    private String name;

    public Product(int id){
        this.id = id;
    }

    public Product(int id, String name, int categoryID) {
        this.id = id;
        this.name = name;
        this.categoryID = categoryID;
    }

    public int getId() {
        return id;
    }

    public int getCategoryID(){
        return categoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategoryID(int categoryID){
        this.categoryID = categoryID;
    }
}
