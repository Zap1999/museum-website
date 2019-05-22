package com.softserve.academy.museum.db;

import com.softserve.academy.museum.util.PropertiesUtil;

import java.sql.*;
import java.util.Properties;
import org.apache.log4j.Logger;

public class MySQLConnection {

    private static final Properties DB_PROPERTIES = PropertiesUtil.getProperties();
    private static final Logger LOGGER = Logger.getLogger(MySQLConnection.class);

    private static final String CLASS = DB_PROPERTIES.getProperty("jdbc.driverClassName");
    private static final String URL = DB_PROPERTIES.getProperty("db.url");
    private static final String USER = DB_PROPERTIES.getProperty("db.user");
    private static final String PASSWORD = DB_PROPERTIES.getProperty("db.password");


    private static Connection connection;

    public static Connection getConnection() {
        if (connection != null) {
            return connection;
        } else {
            try {
                Class.forName(CLASS);
                connection = DriverManager.getConnection(URL,USER,PASSWORD);
                return connection;
            } catch (Exception e) {
                System.err.println("Connection to MySQL DB failed.");
                e.printStackTrace();
                LOGGER.error("Connection",e);
                return null;
            }
        }
    }

}
