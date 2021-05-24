package com.bnpp.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameBoardTest {
    @Test
    void shouldUpdateXWithCoordinate() {
        GameBoard gameBoard = new GameBoard();
        gameBoard.markSymbolAtCoordinates(1,1);
        assertEquals('X', gameBoard.getSymbolAtCoordinates(1,1));
    }

    @Test
    void shouldUpdateSymbolOforSecondMark() {
        GameBoard gameBoard = new GameBoard();
        gameBoard.markSymbolAtCoordinates(1,1);
        gameBoard.markSymbolAtCoordinates(2,1);
        assertEquals('O', gameBoard.getSymbolAtCoordinates(2,1));
    }
}
