package com.chrishong.lil.jdbc;

import com.chrishong.lil.jdbc.util.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO extends DataAccessObject {

    private static final String GET_ONE_BY_ID = "SELECT user_id a, user_name b, password c, " +
            "total_games d FROM users WHERE user_id=?";

    private static final String GET_ONE_BY_USER_NAME = "SELECT user_id, user_name, password, " +
            "total_games FROM users WHERE user_name=?";

    public UserDAO(Connection connection) {
        super(connection);
    }

    public User findById(long id) {
        User user = new User();
        System.out.println(GET_ONE_BY_ID);
        try(PreparedStatement statement = this.connection.prepareStatement(GET_ONE_BY_ID);) {
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                user.setUserId(rs.getLong("a"));
                user.setUserName(rs.getString("b"));
                user.setPassword(rs.getString("c"));
                user.setTotalGames(rs.getInt("d"));
            }
        } catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return user;
    }

    public User findByUserName(String name) {
        User user = new User();
        System.out.println(GET_ONE_BY_USER_NAME);
        try(PreparedStatement statement = this.connection.prepareStatement(GET_ONE_BY_USER_NAME);) {
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                user.setUserId(rs.getLong("user_id"));
                user.setUserName(rs.getString("user_name"));
                user.setPassword(rs.getString("password"));
                user.setTotalGames(rs.getInt("total_games"));
            }
        } catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return user;
    }
}
