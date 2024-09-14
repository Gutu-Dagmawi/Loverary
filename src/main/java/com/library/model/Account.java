package com.library.model;

import java.util.Date;

public class Account {
    private int account_id;
    private String username;
    private String password;
    private Date created_at;
    private Date updated_at;

    public Account(int account_id, String username, String password, Date created_at, Date updated_at) {
        this.account_id = account_id;
        this.username = username;
        this.password = password;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getAccountId() { return account_id; }
    public void setAccountId(int account_id) { this.account_id = account_id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Date getCreatedAt() { return created_at; }
    public void setCreatedAt(Date created_at) { this.created_at = created_at; }

    public Date getUpdatedAt() { return updated_at; }
    public void setUpdatedAt(Date updated_at) { this.updated_at = updated_at; }

    @Override
    public String toString() {
        return "Account{" +
                "account_id=" + account_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        // Equality logic here
        return super.equals(obj);
    }
}
