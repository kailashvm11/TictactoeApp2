package com.bnpp.tictactoe;
import java.util.Arrays;

import static com.bnpp.tictactoe.Symbol.*;

public class GameBoard {
    private Symbol[][] board = new Symbol[3][3];
    private int turnCount = 1;

    public GameBoard() {
        for (Symbol[] row : board) {
            Arrays.fill(row, NO_SYMBOL);
        }
    }

    public char getSymbolAtCoordinates(int row, int column) {
        Coordinates coordinates = new Coordinates(row, column);
        return board[coordinates.getRow()][coordinates.getColumn()].getValue();
    }

    public void markSymbolAtCoordinates(int row, int column) {
        Coordinates coordinates = new Coordinates(row, column);
        updateBoardWithNextSymbol(coordinates);
    }

    private void updateBoardWithNextSymbol(Coordinates coordinates) {
        board[coordinates.getRow()][coordinates.getColumn()] = getNextSymbol();
        incrementTurnCountAfterMarkSymbol();
    }

    private void incrementTurnCountAfterMarkSymbol() {
        turnCount++;
    }

    private Symbol getNextSymbol() {
        if (turnCount == 1) {
            return CROSS;
        }
        return NOUGHT;
    }

}
