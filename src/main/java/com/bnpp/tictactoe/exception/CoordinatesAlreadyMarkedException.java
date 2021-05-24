package com.bnpp.tictactoe.exception;

public class CoordinatesAlreadyMarkedException extends Exception{
    private static final long serialVersionUID = 1934522683050284993L;
    private final String message;

    public CoordinatesAlreadyMarkedException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
