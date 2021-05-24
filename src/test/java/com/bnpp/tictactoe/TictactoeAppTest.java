package com.bnpp.tictactoe;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TictactoeAppTest {
    @Test
    void shouldDisplayStartMessage() {
        Logger appLogger = (Logger) LoggerFactory.getLogger(TictactoeApp.class);
        ListAppender<ILoggingEvent> listAppender;
        listAppender = new ListAppender<>();
        listAppender.start();
        appLogger.addAppender(listAppender);
        TictactoeApp tictactoeApp = new TictactoeApp();
        tictactoeApp.start();
        List<ILoggingEvent> logsList = listAppender.list;
        assertEquals("Starting a new Tic-tac-toe Game", logsList.get(0)
                .getMessage());

    }
}