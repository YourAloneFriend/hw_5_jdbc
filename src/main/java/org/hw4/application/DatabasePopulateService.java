package org.hw4.application;

import org.hw4.application.storage.DataSource;

import java.sql.*;
import java.util.List;

import static org.hw4.application.GetQueries.getQueries;

public class DatabasePopulateService {

    private final static String[][] workerData = {
            {"Vlad", "1999-12-03", "Junior", "400"},
            {"Stas", "1998-10-02", "Junior", "580"},
            {"Nikita", "1994-12-23", "Middle", "1400"},
            {"Volodymyr", "2000-01-10", "Middle", "1200"},
            {"Maxim", "2002-12-13", "Junior", "400"},
            {"George", "2004-03-13", "Trainee", "100"},
            {"Oleksandr", "2003-05-03", "Trainee", "100"},
            {"Viktoria", "1990-11-03", "Senior", "4000"},
            {"Serhei", "1999-08-03", "Senior", "4200"},
            {"Vano", "1989-03-03", "Senior", "5400"}
    };

    private final static String[] clientData = {"Stas", "Marina", "Volodymyr", "Nazar", "Gordon"};

    private final static String[][] projectData = {
            {"1", "2022-03-03", "2023-03-03"},
            {"1", "2022-05-03", "2023-01-23"},
            {"2", "2022-06-13", "2022-07-13"},
            {"2", "2022-10-23", "2022-12-23"},
            {"3", "2022-03-03", "2025-03-03"},
            {"3", "2022-03-03", "2026-03-03"},
            {"4", "2022-03-03", "2024-03-03"},
            {"4", "2022-03-03", "2023-03-03"},
            {"5", "2022-10-03", "2024-03-03"},
            {"5", "2022-10-03", "2023-03-03"}
    };

    private final static int[][] projectWorkerData = {
            {1, 1}, {1, 8}, {1, 5}, {2, 9}, {3, 6}, {3, 7}, {4, 10}, {5, 3}, {6, 2}, {6, 4}, {6, 5},
            {7, 3}, {8, 1}, {8, 8}, {9, 2}, {9, 6}, {10, 6}, {10, 1}, {10, 5}, {10, 10}, {10, 9},
    };

    public static void main(String[] args) {

        List<String> queries = GetQueries.getQueries("src/sql/populate_db.sql");

        try (Connection connection = DataSource.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(queries.get(0))) {
            for (String[] workerInfo : workerData) {
                statement.setString(1, workerInfo[0]);
                statement.setDate(2, Date.valueOf(workerInfo[1]));
                statement.setString(3, workerInfo[2]);
                statement.setInt(4, Integer.valueOf(workerInfo[3]));
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try (Connection connection = DataSource.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(queries.get(1))) {
            for (String clientInfo : clientData) {
                statement.setString(1, clientInfo);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try (Connection connection = DataSource.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(queries.get(2))) {
            for (String[] projectInfo : projectData) {
                statement.setInt(1, Integer.valueOf(projectInfo[0]));
                statement.setDate(2, Date.valueOf(projectInfo[1]));
                statement.setDate(3, Date.valueOf(projectInfo[2]));
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try (Connection connection = DataSource.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(queries.get(3))) {
            for (int[] projectWorkerInfo : projectWorkerData) {
                statement.setInt(1, projectWorkerInfo[0]);
                statement.setInt(2, projectWorkerInfo[1]);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
