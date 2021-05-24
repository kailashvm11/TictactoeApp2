package com.bnpp.tictactoe;

public class GameBoard {
    private char[][] board;

    public GameBoard() {
        this.board = new char[3][3];
    }

    public char getSymbolAtCoordinates(int row, int column) {
        return board[row - 1][column - 1];
    }

    public void markSymbolAtCoordinates(int row, int column) {
        board[row - 1][column -1] = 'X';
    }

}
