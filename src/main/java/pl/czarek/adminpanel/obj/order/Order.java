package pl.czarek.adminpanel.obj.order;

public class Order {
    private int id;
    private String productsID;
    private int data;
    private String status;

    public Order(int id, String productsID, int data, String status){
        this.id = id;
        this.data = data;
        this.status = status;
    }

    public int getId(){
        return id;
    }

    public int getData(){
        return data;
    }

    public String getStatus(){
        return status;
    }

    public String getProductsID(){
        return productsID;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public void setData(int data){
        this.data = data;
    }

    public void setProductsID(String productsID){
        this.productsID = productsID;
    }
}
