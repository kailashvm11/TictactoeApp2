package com.bnpp.tictactoe;
import com.bnpp.tictactoe.exception.CoordinatesAlreadyMarkedException;
import com.bnpp.tictactoe.exception.IncorrectInputFormatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Scanner;

public class TictactoeApp {

    private GameBoard gameBoard = new GameBoard();
    private static final Logger log = LoggerFactory.getLogger(TictactoeApp.class);
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        String restart;
        do {
            play();
            displayGameStatus();
            restart = getRestartInput();
        } while (restart.equals("R"));
    }

    private void play() {
        log.info("Starting a new Tic-tac-toe Game");
        gameBoard = new GameBoard();
        printBoard();
        while(gameBoard.getGameStatus() == GameStatus.IN_PROGRESS) {
            log.info("Enter row and column to mark : " + gameBoard.getNextSymbol().getValue());
            try {
                String input = readInput();
                isInputValid(input);
                gameBoard.markSymbolAtCoordinates(getInteger(input.charAt(0)), getInteger(input.charAt(2)));
            } catch (IncorrectInputFormatException | CoordinatesAlreadyMarkedException e) {
                log.info(e.getMessage());
            }
            printBoard();
        }
    }

    private void printBoard() {
        log.info(gameBoard.getBoard());
    }

    private String readInput() {
        return scanner.nextLine().trim();
    }

    private void isInputValid(String input) throws IncorrectInputFormatException {
        if (!(validateLength(input) && validateComma(input) && validateRange(input))) {
            throw new IncorrectInputFormatException("Please enter only two numbers between 1 and 3 separated by a comma");
        }
    }

    private boolean validateLength(String input) {
        return input.length() == 3;
    }

    private boolean validateComma(String input) {
        return input.charAt(1) == ',';
    }

    private boolean validateRange(String input) {
        return input.charAt(0) >= '1' && input.charAt(0) <= '3' && input.charAt(0) >= '1' && input.charAt(0) <= '3';
    }

    private int getInteger(char input) {
        return Integer.parseInt(String.valueOf(input));
    }

    private void displayGameStatus() {
        log.info(gameBoard.getGameStatus().getValue());
    }


    private String getRestartInput() {
        log.info("Enter R to restart a new Game");
        return scanner.nextLine().trim();
    }

}
