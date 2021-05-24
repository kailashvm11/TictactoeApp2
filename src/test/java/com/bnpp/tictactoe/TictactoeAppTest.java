package com.bnpp.tictactoe;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TictactoeAppTest {

    TictactoeApp tictactoeApp;
    Logger appLogger = (Logger) LoggerFactory.getLogger(TictactoeApp.class);
    ListAppender<ILoggingEvent> listAppender;
    @BeforeEach
    void setUp() {
        listAppender = new ListAppender<>();
        listAppender.start();
        appLogger.addAppender(listAppender);
        tictactoeApp = new TictactoeApp();
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
}
