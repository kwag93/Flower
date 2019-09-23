package com.example.flower;

public class Board {

    String boardname;
    String description;

    public Board(String boardname, String description) {
        this.boardname = boardname;
        this.description = description;
    }

    public String getBoardname() {
        return boardname;
    }

    public void setBoardname(String boardname) {
        this.boardname = boardname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}