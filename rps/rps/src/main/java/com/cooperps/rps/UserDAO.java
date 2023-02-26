package com.cooperps.rps;

import com.cooperps.rps.util.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO extends DataAccessObject {

    private static final String GET_ONE_BY_ID = "SELECT user_id a, user_name b, password c, " +
            "total_games d, total_win e FROM users WHERE user_id=?";

    private static final String GET_ONE_BY_USER_NAME = "SELECT user_id, user_name, password, " +
            "total_games FROM users WHERE user_name=?";

    private static final String UPDATE_WINS_FOR_ID = "UPDATE users SET total_games=?, total_win=? " +
            "WHERE user_id = ?";

    public UserDAO(Connection connection) {
        super(connection);
    }

    public void setGamesAndWins(long id, int wins) {
        System.out.println(UPDATE_WINS_FOR_ID);
        try(PreparedStatement statement = this.connection.prepareStatement(UPDATE_WINS_FOR_ID);) {
            statement.setInt(1, wins);
            statement.setInt(2, wins);
            statement.setLong(3, id);
            statement.execute();
        } catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
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
                user.setTotalWin(rs.getInt("e"));
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
