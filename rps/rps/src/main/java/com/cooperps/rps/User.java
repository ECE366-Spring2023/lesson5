package com.cooperps.rps;

import com.cooperps.rps.util.DataTransferObject;

public class User implements DataTransferObject {
    private long userId;
    private String userName;
    private String password;
    private int totalGames;
    private int totalWin;
    private int totalLoss;
    private int totalTie;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", totalGames=" + totalGames +
                ", totalWin=" + totalWin +
                ", totalLoss=" + totalLoss +
                ", totalTie=" + totalTie +
                '}';
    }

    public long getId() {
        return userId;
    }
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTotalGames() {
        return totalGames;
    }

    public void setTotalGames(int totalGames) {
        this.totalGames = totalGames;
    }

    public int getTotalWin() {
        return totalWin;
    }

    public void setTotalWin(int totalWin) {
        this.totalWin = totalWin;
    }

    public int getTotalLoss() {
        return totalLoss;
    }

    public void setTotalLoss(int totalLoss) {
        this.totalLoss = totalLoss;
    }

    public int getTotalTie() {
        return totalTie;
    }

    public void setTotalTie(int totalTie) {
        this.totalTie = totalTie;
    }
}
