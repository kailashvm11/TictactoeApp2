package com.bnpp.tictactoe;

import com.bnpp.tictactoe.exception.CoordinatesAlreadyMarkedException;
import org.junit.jupiter.api.Test;

import static com.bnpp.tictactoe.Symbol.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GameBoardTest {
    @Test
    void shouldUpdateXWithCoordinate() throws CoordinatesAlreadyMarkedException {
        GameBoard gameBoard = new GameBoard();
        gameBoard.markSymbolAtCoordinates(1,1);
        assertEquals(CROSS, gameBoard.getSymbolAtCoordinates(1,1));
    }

    @Test
    void shouldUpdateSymbolOforSecondMark() throws CoordinatesAlreadyMarkedException {
        GameBoard gameBoard = new GameBoard();
        gameBoard.markSymbolAtCoordinates(1,1);
        gameBoard.markSymbolAtCoordinates(2,1);
        assertEquals(NOUGHT, gameBoard.getSymbolAtCoordinates(2,1));
    }

    @Test
    void shouldThrowExceptionForSameCoordinates() throws CoordinatesAlreadyMarkedException {
        GameBoard gameBoard = new GameBoard();
        gameBoard.markSymbolAtCoordinates(1,1);
        assertThrows(CoordinatesAlreadyMarkedException.class,() -> gameBoard.markSymbolAtCoordinates(1,1));
    }
}
