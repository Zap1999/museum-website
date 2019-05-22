package com.softserve.academy.museum.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
    private static final String PROPERTIES_FILENAME = "/db.properties";

    public static Properties getProperties() {
        Properties properties = new Properties();
        try (InputStream inputStream = PropertiesUtil.class.getResourceAsStream(PROPERTIES_FILENAME)) {
            properties.load(inputStream);
        } catch (IOException e) {
            System.err.println("Properties file init failed.");
            e.printStackTrace();
        }
        return properties;
    }
}