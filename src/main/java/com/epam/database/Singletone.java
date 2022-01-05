package com.epam.database;

import java.sql.*;

public class Singletone {
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    private Singletone() {
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

    public static ResultSet getResultSet(String participantEmail) throws SQLException {
        if (resultSet == null) {
            resultSet = statement.executeQuery("SELECT gender,is_faculty, name, mobile,id,email,status FROM programs.participants where email='" + participantEmail + "';");
        }
        return resultSet;
    }
}
//{comments=<ul><li><h6>undefined</h6><br>Time Stamp :Fri Dec 24 2021 14:31:03 GMT+0530 (India Standard Time)</li></ul><ul><li><h6>undefined</h6><br>Time Stamp :Fri Dec 24 2021 14:24:54 GMT+0530 (India Standard Time)</li></ul><ul><li><h6>undefined</h6><br>Time Stamp :Fri Dec 24 2021 14:23:25 GMT+0530 (India Standard Time)</li></ul><ul><li><h6>undefined</h6><br>Time Stamp :Fri Dec 24 2021 14:21:06 GMT+0530 (India Standard Time)</li></ul><ul><li><h6>undefined</h6><br>Time Stamp :Fri Dec 24 2021 14:19:56 GMT+0530 (India Standard Time)</li></ul><ul><li><h6>undefined</h6><br>Time Stamp :Fri Dec 24 2021 13:31:22 GMT+0530 (India Standard Time)</li></ul>,
// gender=MALE, college_id=303, batch_id=54, is_faculty=1, name=alexandra, mobile=8456951964,
// id=13785, created_date=2021-12-24T11:03:56, updated_date=2021-12-24T14:31:03, email=khabibnagom@gmail.com, status=ACTIVE}