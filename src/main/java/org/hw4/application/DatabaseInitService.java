package org.hw4.application;

import org.hw4.application.storage.DataSource;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import static org.hw4.application.GetQueries.getQueries;
import static org.hw4.application.storage.DataSource.closeConnection;

public class DatabaseInitService {

    public static void main(String[] args) {
        for (String query : getQueries("src/sql/init_db.sql"))
            try (PreparedStatement statement = DataSource.getConnection().prepareStatement(query)) {
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());
            } finally {
                closeConnection();
            }
    }
}
