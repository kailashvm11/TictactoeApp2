package com.bnpp.tictactoe;

import org.junit.jupiter.api.Test;

import static com.bnpp.tictactoe.Symbol.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GameBoardTest {
    @Test
    void shouldUpdateXWithCoordinate() {
        GameBoard gameBoard = new GameBoard();
        gameBoard.markSymbolAtCoordinates(1,1);
        assertEquals(CROSS, gameBoard.getSymbolAtCoordinates(1,1));
    }

    @Test
    void shouldUpdateSymbolOforSecondMark() {
        GameBoard gameBoard = new GameBoard();
        gameBoard.markSymbolAtCoordinates(1,1);
        gameBoard.markSymbolAtCoordinates(2,1);
        assertEquals(NOUGHT, gameBoard.getSymbolAtCoordinates(2,1));
    }
}
