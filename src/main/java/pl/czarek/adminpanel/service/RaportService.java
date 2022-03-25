package pl.czarek.adminpanel.service;

import pl.czarek.adminpanel.obj.raportService.PriceSpendMonth;
import pl.czarek.adminpanel.obj.raportService.SumPriceUsers;

import java.util.ArrayList;

public class RaportService {

    private final  DatabaseService databaseService;

    public RaportService(DatabaseService databaseService){
        this.databaseService = databaseService;
    }

    public ArrayList<SumPriceUsers> SumPriceUsers(){
        try{
            ArrayList<SumPriceUsers> raport = this.databaseService.performQuery(
                    "SELECT u.name, SUM(po.price * po.quantity) AS \"sum price\"\n" +
                            "    FROM orders o\n" +
                            "    INNER JOIN user u ON o.userID = u.id\n" +
                            "    INNER JOIN product_order po ON o.id = po.orderID\n" +
                            "    GROUP BY u.name",
                    resultSet -> {
                        ArrayList<SumPriceUsers> raportQuery = new ArrayList<>();
                        while (resultSet.next()){
                            String name = resultSet.getString("name");
                            float price = resultSet.getFloat("sum price");

                            raportQuery.add(new SumPriceUsers(name, price));
                        }
                        return raportQuery;
                    }
            );
            return raport;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<PriceSpendMonth> PriceSpendMonth(){
        try{
            ArrayList<PriceSpendMonth> raport = this.databaseService.performQuery(
                    "SELECT user.name, MONTH(product_order.createDate) AS \"month\", SUM(product_order.price * product_order.quantity) AS \"sum price\"\n" +
                            "    FROM user \n" +
                            "    INNER JOIN orders ON user.id = orders.userID\n" +
                            "    INNER JOIN product_order ON orders.id = product_order.orderID\n" +
                            "    GROUP BY MONTH(product_order.createDate) ASC",
                    resultSet -> {
                        ArrayList<PriceSpendMonth> raportQuery = new ArrayList<>();
                        while (resultSet.next()){
                            String name = resultSet.getString("name");
                            float price = resultSet.getFloat("sum price");
                            int month = resultSet.getInt("month");

                            raportQuery.add(new PriceSpendMonth(name,month, price));
                        }
                        return raportQuery;
                    }
            );
            return raport;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

   /* public ArrayList ProductQuantity(){
        try{
            ArrayList raport = this.databaseService.performQuery(
                    "SELECT product.name, SUM(product_order.quantity) AS \"quantity\" \n" +
                            "    FROM product\n" +
                            "    INNER JOIN product_order ON product.id = product_order.productID\n" +
                            "    GROUP BY product.name",
                    resultSet -> {
                        ArrayList<PriceSpendMonth> raportQuery = new ArrayList<>();
                        while (resultSet.next()){
                            String name = resultSet.getString("name");
                            int quantity = resultSet.getInt("quantity");

                            raportQuery.add(new PriceSpendMonth(name,month, price));
                        }
                        return raportQuery;
                    }
            );
            return raport;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }*/
}
