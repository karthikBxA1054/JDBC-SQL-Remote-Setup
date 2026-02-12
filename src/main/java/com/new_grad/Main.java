package com.new_grad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {

        String url = "jdbc:sqlserver://hirestream-360.database.windows.net:1433;"
                + "database=hirestream-1220078;"
                + "user=hirestreamuser;"
                + "password=Jan@2206;"
                + "encrypt=true;"
                + "trustServerCertificate=true;"
                + "hostNameInCertificate=*.database.windows.net;"
                + "loginTimeout=30;";

        try {
            Connection connection = DriverManager.getConnection(url);
            System.out.println("Connected successfully!");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select CURRENT_DATE");

            if (resultSet.next()) {
                System.out.println("Current DB Time: " + resultSet);
            }

            resultSet.close();
            statement.close();
            connection.close();

            System.out.println("Done.");

        } catch (Exception e) {
            System.out.println("Something went wrong:");
            e.printStackTrace();
        }
    }
}