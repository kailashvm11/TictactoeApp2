package com.bnpp.tictactoe;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import com.bnpp.tictactoe.exception.CoordinatesAlreadyMarkedException;
import org.junit.jupiter.api.*;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static com.bnpp.tictactoe.GameStatus.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TictactoeAppTest {

    @Nested
    @DisplayName("Test cases without conflicting input")
    class InputMockTestWithoutConflict {

        TictactoeApp tictactoeApp;
        Logger appLogger = (Logger) LoggerFactory.getLogger(TictactoeApp.class);
        ListAppender<ILoggingEvent> listAppender;

        @BeforeEach
        void setUp() {
            listAppender = new ListAppender<>();
            listAppender.start();
            appLogger.addAppender(listAppender);
            setInput("1,1\n2,1\n2,2\n2,3\n3,3\nN\n");
            tictactoeApp = new TictactoeApp();
        }

        @AfterEach
        public void restoreSystemInput() {
            System.setIn(System.in);
        }

        @Test
        void shouldDisplayStartMessage() {
            tictactoeApp.start();
            List<ILoggingEvent> logsList = listAppender.list;
            assertEquals("Starting a new Tic-tac-toe Game", logsList.get(0)
                    .getMessage());

        }

        @Test
        void shouldDisplayEmptyGrid() {
            tictactoeApp.start();
            List<ILoggingEvent> logsList = listAppender.list;
            StringBuilder sb = new StringBuilder();
            sb.append("---------\n");
            sb.append("|       |\n");
            sb.append("|       |\n");
            sb.append("|       |\n");
            sb.append("---------\n");
            assertEquals(sb.toString(), logsList.get(1).getMessage());
        }

        @Test
        void shouldDisplayGridAfterUpdate() {
            TictactoeApp app = new TictactoeApp();
            app.start();
            List<ILoggingEvent> logsList = listAppender.list;
            assertThat(logsList.get(3).getMessage()).containsOnlyOnce("| X     |");
        }

        private void setInput(String input) {
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
        }
    }

    @Nested
    @DisplayName("Input test case with alphabets")
    class InputMockTestForThrowingException {

        TictactoeApp tictactoeApp;
        Logger appLogger = (Logger) LoggerFactory.getLogger(TictactoeApp.class);
        ListAppender<ILoggingEvent> listAppender;

        @AfterEach
        public void restoreSystemInput() {
            System.setIn(System.in);
        }

        @Test
        void shouldDisplayStartMessage() {
            listAppender = new ListAppender<>();
            listAppender.start();
            appLogger.addAppender(listAppender);
            setInput("123\n1,1\n2,1\n2,2\n2,3\n3,3\nN\n");
            tictactoeApp = new TictactoeApp();
            tictactoeApp.start();
            List<ILoggingEvent> logsList = listAppender.list;
            org.assertj.core.api.Assertions.assertThat(listAppender.list)
                    .extracting(ILoggingEvent::getFormattedMessage)
                    .contains("Please enter only two numbers between 1 and 3 separated by a comma");

        }

        private void setInput(String input) {
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
        }
    }

    @Nested
    @DisplayName("Input test case for winning scenario")
    class InputMockTestForXWin {

        TictactoeApp tictactoeApp;
        Logger appLogger = (Logger) LoggerFactory.getLogger(TictactoeApp.class);
        ListAppender<ILoggingEvent> listAppender;

        @AfterEach
        public void restoreSystemInput() {
            System.setIn(System.in);
        }

        @Test
        void shouldDisplayStartMessage()  {
            listAppender = new ListAppender<>();
            listAppender.start();
            appLogger.addAppender(listAppender);
            setInput("1,1\n2,1\n2,2\n2,3\n3,3\nN\n");
            tictactoeApp = new TictactoeApp();
            tictactoeApp.start();
            List<ILoggingEvent> logsList = listAppender.list;
            org.assertj.core.api.Assertions.assertThat(listAppender.list)
                    .extracting(ILoggingEvent::getFormattedMessage)
                    .contains(CROSS_WINS.getValue());

        }

        private void setInput(String input) {
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
        }
    }

    @Nested
    @DisplayName("Input test case with already marked coordinates")
    class InputMockTestForThrowingAlreadyMarkedException {

        TictactoeApp tictactoeApp;
        Logger appLogger = (Logger) LoggerFactory.getLogger(TictactoeApp.class);
        ListAppender<ILoggingEvent> listAppender;

        @AfterEach
        public void restoreSystemInput() {
            System.setIn(System.in);
        }

        @Test
        void shouldDisplayAlreadyMarkedMessage() {
            listAppender = new ListAppender<>();
            listAppender.start();
            appLogger.addAppender(listAppender);
            setInput("1,1\n1,1\n2,1\n2,2\n2,3\n3,3\nN\n");
            tictactoeApp = new TictactoeApp();
            tictactoeApp.start();
            List<ILoggingEvent> logsList = listAppender.list;
            org.assertj.core.api.Assertions.assertThat(listAppender.list)
                    .extracting(ILoggingEvent::getFormattedMessage)
                    .contains("This cell is already filled. Please enter a new one");

        }

        private void setInput(String input) {
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
        }
    }
    @Nested
    @DisplayName("Input test case with restart")
    class InputMockTestForRestartingTheGame {

        TictactoeApp tictactoeApp;
        Logger appLogger = (Logger) LoggerFactory.getLogger(TictactoeApp.class);
        ListAppender<ILoggingEvent> listAppender;

        @AfterEach
        public void restoreSystemInput() {
            System.setIn(System.in);
        }

        @Test
        void shouldDisplayAlreadyMarkedMessage() {
            listAppender = new ListAppender<>();
            listAppender.start();
            appLogger.addAppender(listAppender);
            setInput("1,1\n2,1\n2,2\n2,3\n3,3\nR\n3,1\n1,1\n2,1\n2,2\n2,3\n3,3\nN\n");
            tictactoeApp = new TictactoeApp();
            tictactoeApp.start();
            List<ILoggingEvent> logsList = listAppender.list;
            org.assertj.core.api.Assertions.assertThat(listAppender.list)
                    .extracting(ILoggingEvent::getFormattedMessage)
                    .contains(NOUGHT_WINS.getValue());

        }

        private void setInput(String input) {
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
        }
    }
}
