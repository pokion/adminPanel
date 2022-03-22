package pl.czarek.adminpanel.builder;

import pl.czarek.adminpanel.obj.productOrderOptions.ProductOrder;

public class ProductOrderBuilder {

    private final ProductOrder productOrder;

    public ProductOrderBuilder(){
        this.productOrder = new ProductOrder();
    }

    public ProductOrderBuilder(int id){
        this.productOrder = new ProductOrder(id);
    }

    public ProductOrderBuilder setProductID(int productID){
        this.productOrder.setProductID(productID);
        return this;
    }

    public ProductOrderBuilder setOrderID(int orderID){
        this.productOrder.setOrderID(orderID);
        return this;
    }

    public ProductOrderBuilder setQuantity(int quantity){
        this.productOrder.setQuantity(quantity);
        return this;
    }

    public ProductOrderBuilder setPrice(float price){
        this.productOrder.setPrice(price);
        return this;
    }

    public ProductOrderBuilder setInStock(int inStock){
        this.productOrder.setInStock(inStock);
        return this;
    }

    public ProductOrder getProductOrder(){
        return this.productOrder;
    }

}
