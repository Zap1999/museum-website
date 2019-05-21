package com.softserve.academy.museum.db;

import java.sql.*;

public class MySQLConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/museum"
            + "?useJDBCCompliantTimezoneShift=true"
            + "&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "root";


    private static Connection connection;

    public static Connection getConnection() {
        if (connection != null) {
            return connection;
        } else {
            try {
                connection = DriverManager.getConnection(URL,USER,PASSWORD);
                return connection;
            } catch (SQLException e) {
                System.err.println("Connection to MySQL DB failed.");
                e.printStackTrace();
                return null;
            }
        }
    }

}
