package pl.czarek.adminpanel.obj.productOrderOptions;

public class ProductOrder {
    private int id;
    private int productID;
    private int orderID;
    private int quantity;
    private float price;
    private int inStock;

    public ProductOrder(){}

    public ProductOrder(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public int getProductID(){
        return productID;
    }

    public int getOrderID(){
        return orderID;
    }

    public int getQuantity(){
        return quantity;
    }

    public float getPrice(){
        return price;
    }

    public int getInStock(){
        return inStock;
    }

    public void setProductID(int productID){
        this.productID = productID;
    }

    public void setOrderID(int orderID){
        this.orderID = orderID;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public void setPrice(float price){
        this.price = price;
    }

    public void setInStock(int inStock){
        this.inStock = inStock;
    }
}
