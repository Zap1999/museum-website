package com.softserve.academy.museum.db;

import java.sql.*;

public class MySQLConnection {

    private static Connection connection;

    public static Connection getConnection() {
        if (connection != null) {
            return connection;
        } else {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/museum?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root");
                return connection;
            } catch (ClassNotFoundException e) {
                System.err.println("MySQL driver class not found.");
                e.printStackTrace();
                return null;
            } catch (SQLException e) {
                System.err.println("Connection to MySQL DB failed.");
                e.printStackTrace();
                return null;
            }
        }
    }

}
