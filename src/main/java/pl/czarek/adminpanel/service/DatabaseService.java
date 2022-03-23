package pl.czarek.adminpanel.service;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import pl.czarek.adminpanel.util.ResultParser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseService {
    private static  DatabaseService instance;

    public static  DatabaseService getInstance(){
        if (instance == null){
            instance = new DatabaseService();
        }
        return instance;
    }

    private final HikariDataSource dataSource;

    private DatabaseService(){
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/shop");
        config.setUsername("root");
        config.setPassword("");

        this.dataSource = new HikariDataSource(config);
    }

    public int performDML(String dml){
        try (Connection connection = this.dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(dml)){

            return  statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

            throw new RuntimeException(e);
        }
    }

    public<U> U performQuery(String query, ResultParser<U> parser){
        try(Connection connection = this.dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)){

            ResultSet resultSet = statement.executeQuery();
            return parser.parse(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public ResultSet performQuery(String dml) {
        try (Connection connection = this.dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(dml)){

            return statement.executeQuery();
        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() throws SQLException {
        return this.dataSource.getConnection();
    }
}
