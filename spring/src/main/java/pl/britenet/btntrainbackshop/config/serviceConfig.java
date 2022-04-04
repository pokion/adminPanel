package pl.britenet.btntrainbackshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.czarek.adminpanel.service.*;

@Configuration
public class serviceConfig {

    @Bean
    public ProductService getProductsService(){
        DatabaseService databaseService = DatabaseService.getInstance();
        return new ProductService(databaseService);
    }

    @Bean
    public CategoryService categoryService(){
        DatabaseService databaseService = DatabaseService.getInstance();
        return new CategoryService(databaseService);
    }

    @Bean
    public ProductOrderService productOrderService(){
        DatabaseService databaseService = DatabaseService.getInstance();
        return new ProductOrderService(databaseService);
    }

    @Bean
    public UserService userService(){
        DatabaseService databaseService = DatabaseService.getInstance();
        return new UserService(databaseService);
    }

    @Bean
    public OrderService orderService(){
        DatabaseService databaseService = DatabaseService.getInstance();
        return new OrderService(databaseService);
    }
}
