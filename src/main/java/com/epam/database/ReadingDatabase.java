package com.epam.database;

import lombok.extern.log4j.Log4j2;

import java.sql.*;
import java.util.*;

@Log4j2
public class ReadingDatabase {
    List<String> participantData;


    public List<String> readingParticipantFromDatabase(String participantEmail) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = Singletone.getConnection();
        Statement statement = Singletone.getStatement();
        ResultSet resultSet = Singletone.getResultSet(participantEmail);

        ResultSetMetaData md = resultSet.getMetaData();
        int columns = md.getColumnCount();
        participantData =new LinkedList<>();

        while (resultSet.next()) {
            for (int i = 1; i <= columns; i++) {
                participantData.add(resultSet.getString(i));
            }

            connection.close();
            return participantData;
        }
        return  participantData;
    }
}
