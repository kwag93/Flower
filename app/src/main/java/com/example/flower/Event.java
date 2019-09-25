package com.example.flower;

public class Event {

    String type;
    String date;
    String memo;

    public Event(String type, String date, String memo) {
        this.type = type;
        this.date = date;
        this.memo = memo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
