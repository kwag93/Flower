package com.example.flower;

public class Account {

    String account_context;
    String account_price;
    String account_date;

    public Account(String account_context, String account_price, String account_date) {
        this.account_context = account_context;
        this.account_price = account_price;
        this.account_date = account_date;
    }

    public String getAccount_context() {
        return account_context;
    }

    public void setAccount_context(String account_context) {
        this.account_context = account_context;
    }

    public String getAccount_price() {
        return account_price;
    }

    public void setAccount_price(String account_price) {
        this.account_price = account_price;
    }

    public String getAccount_date() {
        return account_date;
    }

    public void setAccount_date(String account_date) {
        this.account_date = account_date;
    }

}



