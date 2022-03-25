package pl.czarek.adminpanel.obj.raportService;

public class PriceSpendMonth {
    private String name;
    private int month;
    private float sumPrice;

    public PriceSpendMonth(String name, int month, float sumPrice){
        this.name = name;
        this.month = month;
        this.sumPrice = sumPrice;
    }

    public String getName(){
        return name;
    }

    public int getMonth(){
        return month;
    }

    public float getSumPrice(){
        return sumPrice;
    }
}
