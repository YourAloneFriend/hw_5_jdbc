package org.hw4.application;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class GetQueries {

    public static List<String> getQueries(String sqlFilePath){
        List<String> queries = new ArrayList<>();
        try(Reader reader = new FileReader(sqlFilePath);
            BufferedReader br = new BufferedReader(reader)) {
            StringBuilder query;
            while (br.ready()) {
                query = new StringBuilder(br.readLine());
                while (!query.toString().contains(";"))
                    query.append(br.readLine());

                queries.add(query.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        return queries;
    }
}
