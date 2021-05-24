package com.bnpp.tictactoe;

public class GameBoard {
    private char[][] board;
    private int turnCount = 1;

    public GameBoard() {
        this.board = new char[3][3];
    }

    public char getSymbolAtCoordinates(int row, int column) {
        Coordinates coordinates = new Coordinates(row, column);
        return board[coordinates.getRow()][coordinates.getColumn()];
    }

    public void markSymbolAtCoordinates(int row, int column) {
        Coordinates coordinates = new Coordinates(row, column);
        if (turnCount == 1) {
            board[coordinates.getRow()][coordinates.getColumn()] = 'X';
        } else if (turnCount == 2) {
            board[coordinates.getRow()][coordinates.getColumn()] = 'O';
        }
        turnCount++;
    }

}
