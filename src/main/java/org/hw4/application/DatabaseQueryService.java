package org.hw4.application;

import org.hw4.application.module.*;
import org.hw4.application.storage.DataSource;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hw4.application.GetQueries.getQueries;
import static org.hw4.application.storage.DataSource.closeConnection;

public class DatabaseQueryService {

    public static void main(String[] args) {
        try {
            findMaxSalaryWorker().forEach(System.out::println);
            findMaxProjectClient().forEach(System.out::println);
            findLongestProject().forEach(System.out::println);
            findYoungestEldestWorker().forEach(System.out::println);
            printProjectPrices().forEach(System.out::println);
        } catch (RuntimeException e){
            throw e;
        } finally {
            closeConnection();
        }
    }

    public static List<MaxSalaryWorker> findMaxSalaryWorker(){
        List<MaxSalaryWorker> maxSalaryWorkers = new ArrayList<>();

        for (String query : getQueries("src/sql/find_max_salary_worker.sql")) {
            try (PreparedStatement statement = DataSource.getConnection().prepareStatement(query);
                ResultSet resultSet = statement.executeQuery()) {
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
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        return maxSalaryWorkers;
    }

    public static List<MaxProjectClient> findMaxProjectClient(){
        List<MaxProjectClient> maxProjectClients = new ArrayList<>();

        for (String query : getQueries("src/sql/find_max_projects_client.sql")) {
            try (PreparedStatement statement = DataSource.getConnection().prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next())
                    while (resultSet.next())
                        maxProjectClients.add(
                            MaxProjectClient.builder()
                                .id(resultSet.getInt("id"))
                                .name(resultSet.getString("name"))
                                .projectCount(resultSet.getInt("project_count"))
                                .build()
                        );
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        return maxProjectClients;
    }

    public static List<LongestProject> findLongestProject(){
        List<LongestProject> longestProjects = new ArrayList<>();

        for (String query : getQueries("src/sql/find_longest_project.sql")) {
            try (PreparedStatement statement = DataSource.getConnection().prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next())
                    while (resultSet.next())
                        longestProjects.add(
                            LongestProject.builder()
                                .id(resultSet.getInt("id"))
                                .clientId(resultSet.getInt("client_id"))
                                .duration(resultSet.getInt("duration"))
                                .build()
                        );
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        return longestProjects;
    }

    public static List<YoungestEldestWorker> findYoungestEldestWorker(){
        List<YoungestEldestWorker> youngestEldestWorkers = new ArrayList<>();

        for (String query : getQueries("src/sql/find_youngest_eldest_workers.sql")) {
            try (PreparedStatement statement = DataSource.getConnection().prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next())
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
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        return youngestEldestWorkers;
    }

    public static List<ProjectPrices> printProjectPrices(){
        List<ProjectPrices> projectPrices = new ArrayList<>();

        for (String query : getQueries("src/sql/print_project_prices.sql")) {
            try (PreparedStatement statement = DataSource.getConnection().prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next())
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
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        return projectPrices;
    }
}
