package com.mall.entity;

import java.math.BigDecimal;

/**
 * 用户实体类
 * 对应数据库中的user表
 */
public class User {
    private Integer userId;
    private String username;
    private String password;
    private String email;
    private BigDecimal balance;
    private Long createdTime;

    public User() {}

    public User(String username, String password, String email, BigDecimal balance) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.balance = balance;
    }

    // Getters and Setters
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Long createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", balance=" + balance +
                '}';
    }
}
