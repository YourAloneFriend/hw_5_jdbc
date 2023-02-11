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

    private Connection connection;
    private static DataSource dataSource;

    private DataSource(){
        try(InputStream fis = DataSource.class.getClassLoader().getResourceAsStream("application.properties")) {
            if(fis == null)
                throw new IOException("Can't find this file.");

            Properties properties = new Properties();
            properties.load(fis);

            String url = properties.getProperty("mysql.url");
            String username = properties.getProperty("mysql.username");
            String password = properties.getProperty("mysql.password");
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static DataSource getInstance(){
        try {
            if (dataSource == null || dataSource.getConnection().isClosed())
                dataSource = new DataSource();
            return dataSource;
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public Connection getConnection(){
        return connection;
    }
}
