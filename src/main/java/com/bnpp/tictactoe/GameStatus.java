package com.bnpp.tictactoe;

public enum GameStatus {
    IN_PROGRESS("Game is in progress"),
    DRAW("Game ended in Draw");

    private String value;

    GameStatus(String value) {
        this.value = value;
    }
}
