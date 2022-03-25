package pl.czarek.adminpanel.obj.raportService;

public class SumPriceUsers {

    private String name;
    private float price;

    public SumPriceUsers(String name, float price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public float getPrice(){
        return price;
    }
}
