package org.hw4.application;

import org.hw4.application.storage.DataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static org.hw4.application.GetQueries.getQueries;

public class DatabaseInitService {

    public static void main(String[] args) {
        try (Connection connection = DataSource.getInstance().getConnection();
             Statement statement = connection.createStatement()) {
            for (String query : getQueries("src/sql/init_db.sql"))
                statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
