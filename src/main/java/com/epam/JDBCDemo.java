package com.epam;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {


    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //step-1 register driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        //step 2- loading driver
        Connection connection = SingletoneDemo.getConnection();
        Connection connection1 = SingletoneDemo.getConnection();
        System.out.println("checking singletone implemented for Connection \n" + connection.equals(connection1));
        //connection checking
        System.out.println("\nConnection is close or not :\n" + connection.isClosed());

        //step 3 creating statement object
        Statement statement = SingletoneDemo.getStatement();
        Statement statement1 = SingletoneDemo.getStatement();
        System.out.println("\nchecking singletone implemented for statement \n" + statement.equals(statement1));

        //step -4 execute queries

        ResultSet resultSet = SingletoneDemo.getResultSet();
        ResultSet resultSet1 = SingletoneDemo.getResultSet();
        System.out.println("\nchecking singletone implemented or not for resultset \n" + resultSet.equals(resultSet1) + "\n");

        System.out.println("Result set will display all the speaker names present in speaker_info table :");
        while (resultSet.next()) {
            System.out.println(resultSet.getString("speaker_name"));
        }
        connection.close();
        System.out.println("\n\nConnection is closed or not :\n" + connection.isClosed());

    }
}
