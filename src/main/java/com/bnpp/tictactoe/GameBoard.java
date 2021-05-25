package com.bnpp.tictactoe;
import com.bnpp.tictactoe.exception.CoordinatesAlreadyMarkedException;

import java.util.Arrays;

import static com.bnpp.tictactoe.Symbol.*;
import static com.bnpp.tictactoe.GameStatus.*;

public class GameBoard {
    private Symbol[][] board = new Symbol[3][3];
    private int turnCount = 1;
    private GameStatus gameStatus;

    public GameBoard() {
        gameStatus = IN_PROGRESS;
        for (Symbol[] row : board) {
            Arrays.fill(row, NO_SYMBOL);
        }
    }

    public String getBoard() {
        StringBuilder sb = new StringBuilder();
        sb.append("---------\n");
        for (Symbol[] row : board) {
            sb.append("| ");
            for (Symbol cell : row) {
                sb.append(cell.getValue()).append(" ");
            }
            sb.append("|\n");
        }
        sb.append("---------\n");
        return sb.toString();
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
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
        updateCoordinatesWithNextSymbol(coordinates);
        updateGameWinnerIfPatternMatches();
        incrementTurnCountAfterMarkSymbol();
    }

    private void updateCoordinatesWithNextSymbol(Coordinates coordinates) {
        board[coordinates.getRow()][coordinates.getColumn()] = getNextSymbol();
    }

    public Symbol getNextSymbol() {
        return turnCount % 2  == 0 ? NOUGHT : CROSS;
    }

    private void updateGameWinnerIfPatternMatches() {
        if (turnCount >= 5) {
            if(isGameWon()) {
                gameStatus = getNextSymbol().getValue() == 'X' ? CROSS_WINS : NOUGHT_WINS;
            } else {
                checkForDraw();
            }
        }
    }

    private void checkForDraw() {
        if (turnCount == 9) {
            gameStatus = DRAW;
        }
    }

    private boolean isGameWon() {
        return checkHorizontalRows() || checkVerticalRows() || checkDiagonalRows();
    }


    private boolean checkHorizontalRows() {
        boolean match = false;
        for (int row = 0; row < 3; row++) {
            match = match || areSymbolsMatching(board[row][0], board[row][1], board[row][2]);
        }
        return match;
    }

    private boolean areSymbolsMatching(Symbol symbol1, Symbol symbol2, Symbol symbol3) {
        return symbol1 == symbol2 && symbol1 == symbol3 && symbol1 != NO_SYMBOL;
    }

    private boolean checkVerticalRows() {
        boolean match = false;
        for (int column = 0; column < 3; column++) {
            match = match || areSymbolsMatching(board[0][column], board[1][column], board[2][column]);
        }
        return match;
    }

    private boolean checkDiagonalRows() {
        return checkFrontDiagonalRow() || checkBackDiagonalRow();
    }

    private boolean checkFrontDiagonalRow() {
        return areSymbolsMatching(board[0][0],board[1][1],board[2][2]);
    }

    private boolean checkBackDiagonalRow() {
        return areSymbolsMatching(board[0][2],board[1][1],board[2][0]);
    }

    private void incrementTurnCountAfterMarkSymbol() {
        turnCount++;
    }

}
