package org.hw4.application;

import org.hw4.application.module.*;
import org.hw4.application.storage.DataSource;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hw4.application.GetQueries.getQueries;

public class DatabaseQueryService {

    public static List<MaxSalaryWorker> findMaxSalaryWorker(){
        List<MaxSalaryWorker> maxSalaryWorkers = new ArrayList<>();

        try (Connection connection = DataSource.getInstance().getConnection();
             Statement statement = connection.createStatement()) {
            for (String query : getQueries("src/sql/find_max_salary_worker.sql")) {
                try(ResultSet resultSet = statement.executeQuery(query)) {
                    while (resultSet.next())
                        maxSalaryWorkers.add(
                                MaxSalaryWorker.builder()
                                        .id(resultSet.getInt("id"))
                                        .name(resultSet.getString("name"))
                                        .birthday(LocalDate.parse(resultSet.getString("birthday")))
                                        .level(resultSet.getString("level"))
                                        .salary(resultSet.getInt("salary"))
                                        .build()
                        );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

        return maxSalaryWorkers;
    }

    public static List<MaxProjectClient> findMaxProjectClient(){
        List<MaxProjectClient> maxProjectClients = new ArrayList<>();

        try (Connection connection = DataSource.getInstance().getConnection();
             Statement statement = connection.createStatement())  {
            for (String query : getQueries("src/sql/find_max_projects_client.sql")) {
                try(ResultSet resultSet = statement.executeQuery(query)) {
                    while (resultSet.next())
                        maxProjectClients.add(
                                MaxProjectClient.builder()
                                        .id(resultSet.getInt("id"))
                                        .name(resultSet.getString("name"))
                                        .projectCount(resultSet.getInt("project_count"))
                                        .build()
                        );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

        return maxProjectClients;
    }

    public static List<LongestProject> findLongestProject(){
        List<LongestProject> longestProjects = new ArrayList<>();

        try (Connection connection = DataSource.getInstance().getConnection();
             Statement statement = connection.createStatement())  {
            for (String query : getQueries("src/sql/find_longest_project.sql")) {
                try(ResultSet resultSet = statement.executeQuery(query)) {
                    while (resultSet.next())
                        longestProjects.add(
                                LongestProject.builder()
                                        .id(resultSet.getInt("id"))
                                        .clientId(resultSet.getInt("client_id"))
                                        .duration(resultSet.getInt("duration"))
                                        .build()
                        );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

        return longestProjects;
    }

    public static List<YoungestEldestWorker> findYoungestEldestWorker(){
        List<YoungestEldestWorker> youngestEldestWorkers = new ArrayList<>();

        try (Connection connection = DataSource.getInstance().getConnection();
             Statement statement = connection.createStatement())  {
            for (String query : getQueries("src/sql/find_youngest_eldest_workers.sql")) {
                try(ResultSet resultSet = statement.executeQuery(query)) {
                    while (resultSet.next())
                        youngestEldestWorkers.add(
                                YoungestEldestWorker.builder()
                                        .id(resultSet.getInt("id"))
                                        .name(resultSet.getString("name"))
                                        .birthday(LocalDate.parse(resultSet.getString("birthday")))
                                        .level(resultSet.getString("level"))
                                        .salary(resultSet.getInt("salary"))
                                        .type(resultSet.getString("type"))
                                        .build()
                        );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

        return youngestEldestWorkers;
    }

    public static List<ProjectPrices> printProjectPrices(){
        List<ProjectPrices> projectPrices = new ArrayList<>();

        try (Connection connection = DataSource.getInstance().getConnection();
             Statement statement = connection.createStatement())  {
            for (String query : getQueries("src/sql/print_project_prices.sql")) {
                try(ResultSet resultSet = statement.executeQuery(query)) {
                    while (resultSet.next())
                        projectPrices.add(
                                ProjectPrices.builder()
                                        .projectId(resultSet.getInt("duration_project.id"))
                                        .clientId(resultSet.getInt("client_id"))
                                        .startDate(LocalDate.parse(resultSet.getString("start_date")))
                                        .finishDate(LocalDate.parse(resultSet.getString("finish_date")))
                                        .cost(resultSet.getDouble("cost"))
                                        .build()
                        );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

        return projectPrices;
    }
}
