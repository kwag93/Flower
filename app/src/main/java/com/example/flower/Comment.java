package com.example.flower;

public class Comment {

    String name;
    String text;
    String time;

    public Comment(String name, String text, String time) {
        this.name = name;
        this.text = text;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
