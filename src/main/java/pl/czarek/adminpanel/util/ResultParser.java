package pl.czarek.adminpanel.util;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultParser<U> {

    U parse(ResultSet resultSet) throws SQLException;
}
