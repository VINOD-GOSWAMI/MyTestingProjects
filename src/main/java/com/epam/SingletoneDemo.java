package com.epam;

import java.sql.*;

public class SingletoneDemo {
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    private SingletoneDemo() {
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection("jdbc:mysql://EPINHYDW0087:3306/Programs", "qa", "qa123");
        }
        return connection;
    }

    public static Statement getStatement() throws SQLException {
        if (statement == null) {
            statement = connection.createStatement();
        }
        return statement;
    }

    public static ResultSet getResultSet() throws SQLException {
        if (resultSet == null) {
            resultSet = statement.executeQuery("select * from Programs.speaker_info");
        }
        return resultSet;
    }
}
