package com.bnpp.tictactoe;
import com.bnpp.tictactoe.exception.CoordinatesAlreadyMarkedException;

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

    public Symbol getSymbolAtCoordinates(int row, int column) {
        Coordinates coordinates = new Coordinates(row, column);
        return board[coordinates.getRow()][coordinates.getColumn()];
    }

    public void markSymbolAtCoordinates(int row, int column) throws CoordinatesAlreadyMarkedException {
        Coordinates coordinates = new Coordinates(row, column);
        if (isCoordinatesNotFilled(coordinates)) {
            updateBoardWithNextSymbol(coordinates);
        } else {
            throw new CoordinatesAlreadyMarkedException("This cell is already filled. Please enter a new one");
        }
    }

    public boolean isCoordinatesNotFilled(Coordinates coordinates) {
        return (board[coordinates.getRow()][coordinates.getColumn()].equals(NO_SYMBOL)) ;
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
