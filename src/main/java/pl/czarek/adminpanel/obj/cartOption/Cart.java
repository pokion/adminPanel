package pl.czarek.adminpanel.obj.cartOption;

public class Cart {
    private int id;
    private String listProduct;
    private int userID;
    private String status;

    public Cart(int id){
        this.id = id;
    }

    public Cart(int id, String listProduct, int userID, String status){
        this.id = id;
        this.listProduct = listProduct;
        this.userID = userID;
        this.status = status;
    }

    public int getId(){
        return id;
    }

    public String getListProduct(){
        return listProduct;
    }

    public int getUserID(){
        return userID;
    }

    public String getStatus(){
        return status;
    }

    public void setListProduct(String listProduct){
        this.listProduct = listProduct;
    }

    public void setUserID(int userID){
        this.userID = userID;
    }

    public void setStatus(String status){
        this.status = status;
    }
}
