package com.bnpp.tictactoe;

public enum GameStatus {
    IN_PROGRESS("Game is in progress"),
    DRAW("Game ended in Draw"),
    CROSS_WINS("X wins the Game"),
    NOUGHT_WINS("O wins the Game");

    private String value;

    GameStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
