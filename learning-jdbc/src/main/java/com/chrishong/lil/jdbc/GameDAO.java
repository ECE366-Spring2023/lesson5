package com.chrishong.lil.jdbc;

import com.chrishong.lil.jdbc.util.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GameDAO extends DataAccessObject{

    public GameDAO(Connection connection) {
        super(connection);
    }
    private static final String GET_ONE_BY_ID = "SELECT game_id, winner, rounds, p1_id, " +
            "p2_id FROM game WHERE game_id=?";

    private static final String INSERT_GAME = "INSERT INTO game (rounds, p1_id, p2_id) " +
            "VALUES (?, ?, ?)";

    public Game findById(long id) {
        Game game = new Game();
        System.out.println(GET_ONE_BY_ID);
        try(PreparedStatement statement = this.connection.prepareStatement(GET_ONE_BY_ID);) {
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                game.setGameId(rs.getLong("game_id"));
                game.setWinner(rs.getInt("winner"));
                game.setRounds(rs.getInt("rounds"));
                game.setP1Id(rs.getInt("p1_id"));
                game.setP2Id(rs.getInt("p2_id"));
            }
        } catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return game;
    }

    public Game insertGame(int rounds, long p1Id, long p2Id) {
        Game game = new Game();
        System.out.println(INSERT_GAME);
        try(PreparedStatement statement = this.connection.prepareStatement(INSERT_GAME);) {
            statement.setInt(1, rounds);
            statement.setLong(2, p1Id);
            statement.setLong(3, p2Id);
            statement.execute();
        } catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return game;
    }
}
