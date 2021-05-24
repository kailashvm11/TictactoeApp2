package com.bnpp.tictactoe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TictactoeApp {

    private GameBoard gameBoard = new GameBoard();
    private static final Logger log = LoggerFactory.getLogger(TictactoeApp.class);

    public void start() {
        log.info("Starting a new Tic-tac-toe Game");
        log.info(gameBoard.getBoard());
    }

}
