package com.bnpp.tictactoe;
import com.bnpp.tictactoe.exception.CoordinatesAlreadyMarkedException;

import java.util.Arrays;

import static com.bnpp.tictactoe.Symbol.*;

public class GameBoard {
    private Symbol[][] board = new Symbol[3][3];
    private int turnCount = 1;
    private char gameWinner;

    public GameBoard() {
        for (Symbol[] row : board) {
            Arrays.fill(row, NO_SYMBOL);
        }
    }

    public char getGameWinner() {
        return gameWinner;
    }

    public Symbol getSymbolAtCoordinates(int row, int column) {
        Coordinates coordinates = new Coordinates(row, column);
        return getSymbolFromBoard(coordinates);
    }

    private Symbol getSymbolFromBoard(Coordinates coordinates) {
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
        return (getSymbolFromBoard(coordinates).equals(NO_SYMBOL)) ;
    }

    private void updateBoardWithNextSymbol(Coordinates coordinates) {
        board[coordinates.getRow()][coordinates.getColumn()] = getNextSymbol();
        if (turnCount >= 5) {
            if(isGameWon()) {
                gameWinner = getNextSymbol().getValue();
            }
        }
        incrementTurnCountAfterMarkSymbol();
    }

    private Symbol getNextSymbol() {
        return turnCount % 2  == 0 ? NOUGHT : CROSS;
    }

    private boolean isGameWon() {
        return checkHorizontalFirstRow();
    }

    private boolean checkHorizontalFirstRow() {
        return  (board[0][0] == board[0][1] && board[0][0] == board[0][2]);
    }

    private void incrementTurnCountAfterMarkSymbol() {
        turnCount++;
    }

}
