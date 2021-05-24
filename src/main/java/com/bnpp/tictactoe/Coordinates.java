package com.bnpp.tictactoe;

public class Coordinates {

    private final int row;
    private final int column;

    public Coordinates(int row, int column) {
        this.row = row - 1;
        this.column = column -1;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

}
