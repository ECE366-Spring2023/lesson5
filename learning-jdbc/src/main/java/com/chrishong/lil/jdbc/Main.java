package com.chrishong.lil.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
                "rps", "postgres", "password");

        try {
            Connection connection = dcm.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM users");
            while(resultSet.next()){
                System.out.println(resultSet.getInt(1));
            }

            UserDAO userDAO = new UserDAO(connection);
            User user = userDAO.findById(1);
            System.out.println(user);
            user = userDAO.findByUserName("jsig4");
            System.out.println(user);

            GameDAO gameDAO = new GameDAO(connection);
            gameDAO.insertGame(3, 1, 2);
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
}