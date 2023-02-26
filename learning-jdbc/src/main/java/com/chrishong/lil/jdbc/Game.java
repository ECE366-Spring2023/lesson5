package com.chrishong.lil.jdbc;

import com.chrishong.lil.jdbc.util.DataTransferObject;

public class Game implements DataTransferObject {
    private long gameId;
    private int winner;
    private int rounds;

    public long getId() {
        return gameId;
    }

    @Override
    public String toString() {
        return "Game{" +
                "gameId=" + gameId +
                ", winner=" + winner +
                ", rounds=" + rounds +
                ", p1Id=" + p1Id +
                ", p2Id=" + p2Id +
                '}';
    }

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public int getWinner() {
        return winner;
    }

    public void setWinner(int winner) {
        this.winner = winner;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public long getP1Id() {
        return p1Id;
    }

    public void setP1Id(long p1Id) {
        this.p1Id = p1Id;
    }

    public long getP2Id() {
        return p2Id;
    }

    public void setP2Id(long p2Id) {
        this.p2Id = p2Id;
    }

    private long p1Id;
    private long p2Id;

}
