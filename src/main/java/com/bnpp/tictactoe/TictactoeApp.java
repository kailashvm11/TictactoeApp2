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

    public void start() throws CoordinatesAlreadyMarkedException {
        log.info("Starting a new Tic-tac-toe Game");
        log.info(gameBoard.getBoard());
        play();
    }

    private void play() throws CoordinatesAlreadyMarkedException {
        log.info("Enter row and column to mark : " + gameBoard.getNextSymbol().getValue());
        try {
            String input = readInput();
            if (isInputValid(input)) {
                gameBoard.markSymbolAtCoordinates(getInteger(input.charAt(0)), getInteger(input.charAt(2)));
            } else {
                throw new IncorrectInputFormatException("Please enter only two numbers between 1 and 3 separated by a comma");
            }
        } catch (IncorrectInputFormatException e) {
            log.info("Please enter only two numbers between 1 and 3 separated by a comma");
        }
        log.info(gameBoard.getBoard());
    }

    private String readInput() {
        return scanner.nextLine().trim();
    }

    private boolean isInputValid(String input) {
        return validateLength(input) && validateComma(input) && validateRange(input);
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



}
