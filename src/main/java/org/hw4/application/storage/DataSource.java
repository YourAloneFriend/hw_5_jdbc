package org.hw4.application.storage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource {

    private final static Connection connection;

    static {
        try(InputStream fis = DataSource.class.getClassLoader().getResourceAsStream("application.properties")) {
            if(fis == null)
                throw new IOException("Can't find this file.");

            Properties properties = new Properties();
            properties.load(fis);

            String url = properties.getProperty("mysql.url");
            String username = properties.getProperty("mysql.username");
            String password = properties.getProperty("mysql.password");
            System.out.printf("%s, %s, %s\n", url, username, password);
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static Connection getConnection(){
        return connection;
    }
}
