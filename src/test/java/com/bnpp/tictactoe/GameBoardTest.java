package com.bnpp.tictactoe;

import com.bnpp.tictactoe.exception.CoordinatesAlreadyMarkedException;
import org.junit.jupiter.api.Test;

import static com.bnpp.tictactoe.Symbol.*;
import static com.bnpp.tictactoe.GameStatus.*;
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

    @Test
    void shouldUpdateSymbolXforThirdMark() throws CoordinatesAlreadyMarkedException {
        GameBoard gameBoard = new GameBoard();
        gameBoard.markSymbolAtCoordinates(1,1);
        gameBoard.markSymbolAtCoordinates(2,1);
        gameBoard.markSymbolAtCoordinates(2,2);
        assertEquals(CROSS, gameBoard.getSymbolAtCoordinates(2,2));
    }

    @Test
    void shouldUpdateSymbol0forFourthMark() throws CoordinatesAlreadyMarkedException {
        GameBoard gameBoard = new GameBoard();
        gameBoard.markSymbolAtCoordinates(1,1);
        gameBoard.markSymbolAtCoordinates(2,1);
        gameBoard.markSymbolAtCoordinates(2,2);
        gameBoard.markSymbolAtCoordinates(3,1);
        assertEquals(NOUGHT, gameBoard.getSymbolAtCoordinates(3,1));
    }

    @Test
    void shouldBeWinForXWithHorizontalFirstRow() throws CoordinatesAlreadyMarkedException {
        GameBoard gameBoard = new GameBoard();
        gameBoard.markSymbolAtCoordinates(1,1);
        gameBoard.markSymbolAtCoordinates(3,1);
        gameBoard.markSymbolAtCoordinates(1,2);
        gameBoard.markSymbolAtCoordinates(3,2);
        gameBoard.markSymbolAtCoordinates(1,3);
        assertEquals(CROSS_WINS, gameBoard.getGameStatus());
    }

    @Test
    void shouldBeWinForXWithHorizontalSecondRow() throws CoordinatesAlreadyMarkedException {
        GameBoard gameBoard = new GameBoard();
        gameBoard.markSymbolAtCoordinates(2,1);
        gameBoard.markSymbolAtCoordinates(1,1);
        gameBoard.markSymbolAtCoordinates(2,2);
        gameBoard.markSymbolAtCoordinates(1,2);
        gameBoard.markSymbolAtCoordinates(2,3);
        assertEquals(CROSS_WINS, gameBoard.getGameStatus());
    }

    @Test
    void shouldBeWinForXWithHorizontalThirdRow() throws CoordinatesAlreadyMarkedException {
        GameBoard gameBoard = new GameBoard();
        gameBoard.markSymbolAtCoordinates(3,1);
        gameBoard.markSymbolAtCoordinates(1,1);
        gameBoard.markSymbolAtCoordinates(3,2);
        gameBoard.markSymbolAtCoordinates(2,2);
        gameBoard.markSymbolAtCoordinates(3,3);
        assertEquals(CROSS_WINS, gameBoard.getGameStatus());
    }

    @Test
    void shouldBeWinForXWithVerticalFirstRow() throws CoordinatesAlreadyMarkedException {
        GameBoard gameBoard = new GameBoard();
        gameBoard.markSymbolAtCoordinates(3,1);
        gameBoard.markSymbolAtCoordinates(3,2);
        gameBoard.markSymbolAtCoordinates(2,1);
        gameBoard.markSymbolAtCoordinates(1,2);
        gameBoard.markSymbolAtCoordinates(1,1);
        assertEquals(CROSS_WINS, gameBoard.getGameStatus());
    }

    @Test
    void shouldBeWinForXWithVerticalSecondRow() throws CoordinatesAlreadyMarkedException {
        GameBoard gameBoard = new GameBoard();
        gameBoard.markSymbolAtCoordinates(2,2);
        gameBoard.markSymbolAtCoordinates(3,1);
        gameBoard.markSymbolAtCoordinates(1,2);
        gameBoard.markSymbolAtCoordinates(1,3);
        gameBoard.markSymbolAtCoordinates(3,2);
        assertEquals(CROSS_WINS, gameBoard.getGameStatus());
    }

    @Test
    void shouldBeWinForXWithVerticalThirdRow() throws CoordinatesAlreadyMarkedException {
        GameBoard gameBoard = new GameBoard();
        gameBoard.markSymbolAtCoordinates(2,3);
        gameBoard.markSymbolAtCoordinates(3,1);
        gameBoard.markSymbolAtCoordinates(1,3);
        gameBoard.markSymbolAtCoordinates(1,2);
        gameBoard.markSymbolAtCoordinates(3,3);
        assertEquals(CROSS_WINS, gameBoard.getGameStatus());
    }

    @Test
    void shouldBeWinForXWithFrontDiagonalRow() throws CoordinatesAlreadyMarkedException {
        GameBoard gameBoard = new GameBoard();
        gameBoard.markSymbolAtCoordinates(2,2);
        gameBoard.markSymbolAtCoordinates(3,1);
        gameBoard.markSymbolAtCoordinates(1,1);
        gameBoard.markSymbolAtCoordinates(1,2);
        gameBoard.markSymbolAtCoordinates(3,3);
        assertEquals(CROSS_WINS, gameBoard.getGameStatus());
    }

    @Test
    void shouldBeWinForXWithBackDiagonalRow() throws CoordinatesAlreadyMarkedException {
        GameBoard gameBoard = new GameBoard();
        gameBoard.markSymbolAtCoordinates(2,2);
        gameBoard.markSymbolAtCoordinates(1,1);
        gameBoard.markSymbolAtCoordinates(3,1);
        gameBoard.markSymbolAtCoordinates(1,2);
        gameBoard.markSymbolAtCoordinates(1,3);
        assertEquals(CROSS_WINS, gameBoard.getGameStatus());
    }

    @Test
    void shouldBeDrawAfterNineTurns() throws CoordinatesAlreadyMarkedException {
        GameBoard gameBoard = new GameBoard();
        gameBoard.markSymbolAtCoordinates(1,1);
        gameBoard.markSymbolAtCoordinates(3,3);
        gameBoard.markSymbolAtCoordinates(2,2);
        gameBoard.markSymbolAtCoordinates(2,1);
        gameBoard.markSymbolAtCoordinates(3,1);
        gameBoard.markSymbolAtCoordinates(1,3);
        gameBoard.markSymbolAtCoordinates(1,2);
        gameBoard.markSymbolAtCoordinates(3,2);
        gameBoard.markSymbolAtCoordinates(2,3);
        assertEquals(DRAW, gameBoard.getGameStatus());
    }

    @Test
    void shouldBeGameInProgressAfterFirstTurn() throws CoordinatesAlreadyMarkedException {
        GameBoard gameBoard = new GameBoard();
        gameBoard.markSymbolAtCoordinates(1,1);
        assertEquals(IN_PROGRESS, gameBoard.getGameStatus());
    }


    @Test
    void shouldBeWinForOWithHorizontalThirdRow() throws CoordinatesAlreadyMarkedException {
        GameBoard gameBoard = new GameBoard();
        gameBoard.markSymbolAtCoordinates(1,2);
        gameBoard.markSymbolAtCoordinates(3,2);
        gameBoard.markSymbolAtCoordinates(1,1);
        gameBoard.markSymbolAtCoordinates(3,1);
        gameBoard.markSymbolAtCoordinates(2,3);
        gameBoard.markSymbolAtCoordinates(3,3);
        assertEquals(NOUGHT_WINS, gameBoard.getGameStatus());
    }

    @Test
    void shouldBeWinForOWithDiaganolRow() throws CoordinatesAlreadyMarkedException {
        GameBoard gameBoard = new GameBoard();
        gameBoard.markSymbolAtCoordinates(1,2);
        gameBoard.markSymbolAtCoordinates(3,3);
        gameBoard.markSymbolAtCoordinates(1,3);
        gameBoard.markSymbolAtCoordinates(1,1);
        gameBoard.markSymbolAtCoordinates(2,3);
        gameBoard.markSymbolAtCoordinates(2,2);
        assertEquals(NOUGHT_WINS, gameBoard.getGameStatus());
    }

    @Test
    void shouldBeWinForOWithVerticalThirdRow() throws CoordinatesAlreadyMarkedException {
        GameBoard gameBoard = new GameBoard();
        gameBoard.markSymbolAtCoordinates(2,2);
        gameBoard.markSymbolAtCoordinates(3,1);
        gameBoard.markSymbolAtCoordinates(1,3);
        gameBoard.markSymbolAtCoordinates(3,2);
        gameBoard.markSymbolAtCoordinates(2,3);
        gameBoard.markSymbolAtCoordinates(1,2);
        gameBoard.markSymbolAtCoordinates(1,1);
        gameBoard.markSymbolAtCoordinates(3,3);
        assertEquals(NOUGHT_WINS, gameBoard.getGameStatus());
    }
}
