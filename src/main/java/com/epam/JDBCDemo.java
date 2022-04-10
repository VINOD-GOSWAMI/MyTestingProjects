package com.epam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {
    private static final Logger logger = LogManager.getLogger(JDBCDemo.class);
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //step-1 register driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        //step 2- loading driver
        Connection connection = SingletoneDemo.getConnection();

        Connection connection1 = SingletoneDemo.getConnection();
        logger.info("checking singletone implemented for Connection \n{}" , connection.equals(connection1));
        //connection checking
        logger.info("\nConnection is close or not :\n{}" , connection.isClosed());

        //step 3 creating statement object
        Statement statement = SingletoneDemo.getStatement();
        Statement statement1 = SingletoneDemo.getStatement();
        logger.info("\nchecking singletone implemented for statement \n{}" , statement.equals(statement1));

        //step -4 execute queries

        ResultSet resultSet = SingletoneDemo.getResultSet();
        ResultSet resultSet1 = SingletoneDemo.getResultSet();
        logger.info("\nchecking singletone implemented or not for resultset \n{}\n" , resultSet.equals(resultSet1));

        logger.info("Result set will display all the speaker names present in speaker_info table :");
        while (resultSet.next()) {
            logger.info(resultSet.getString("speaker_name"));
        }
        connection.close();
        logger.info("\n\nConnection is closed or not :\n{}" , connection.isClosed());
    }
}

