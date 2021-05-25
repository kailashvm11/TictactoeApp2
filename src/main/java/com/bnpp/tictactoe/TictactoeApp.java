package com.bnpp.tictactoe;
import com.bnpp.tictactoe.exception.CoordinatesAlreadyMarkedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Scanner;

public class TictactoeApp {

    private GameBoard gameBoard = new GameBoard();
    private static final Logger log = LoggerFactory.getLogger(TictactoeApp.class);
    private Scanner scanner = new Scanner(System.in);

    public void start() throws CoordinatesAlreadyMarkedException {
        log.info("Starting a new Tic-tac-toe Game");
        log.info(gameBoard.getBoard());
        play();
    }

    private void play() throws CoordinatesAlreadyMarkedException {
        log.info("Enter row and column to mark : " + gameBoard.getNextSymbol().getValue());
        String[] input = readInput();
        gameBoard.markSymbolAtCoordinates(getInteger(input[0]), getInteger(input[1]));
        log.info(gameBoard.getBoard());
    }

    private String[] readInput() {
        return scanner.nextLine().split(",");
    }

    private int getInteger(String input) {
        return Integer.parseInt(input);
    }



}
