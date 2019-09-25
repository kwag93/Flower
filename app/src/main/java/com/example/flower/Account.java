package com.example.flower;

public class Account {

    String history;
    String price;
    String date;

    public Account(String history, String price, String date) {
        this.history = history;
        this.price = price;
        this.date = date;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
