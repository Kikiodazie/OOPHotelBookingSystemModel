package com.users;

public class Account {
    private String name;
    private int accountId;
    private String emailId;

    public Account(String name, int accountId, String emailId){
        this.name = name;
        this.accountId = accountId;
        this.emailId = emailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
