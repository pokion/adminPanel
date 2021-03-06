package pl.czarek.adminpanel.obj.categoryOptions;

public class Category {
    private int id;
    private String name;

    public Category(){
        this.id = 0;
    }

    public Category(int id){
        this.id = id;
    }

    public Category(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
