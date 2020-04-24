package com.grapoj.domain.user;

public class User {
    private String userID;
    private String password;
    private Integer permission;

    public User() {
    }

    public User(String userID, String password, Integer permission) {
        this.userID = userID;
        this.password = password;
        this.permission = permission;
    }

    public User(String userID, String password) {
        this.userID = userID;
        this.password = password;
        this.permission = 0;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID='" + userID + '\'' +
                ", password='" + password + '\'' +
                ", permission=" + permission +
                '}';
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPermission() {
        return permission;
    }

    public void setPermission(Integer permission) {
        this.permission = permission;
    }
}
