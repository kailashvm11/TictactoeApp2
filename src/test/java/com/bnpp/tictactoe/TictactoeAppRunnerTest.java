package com.bnpp.tictactoe;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static com.bnpp.tictactoe.GameStatus.DRAW;

public class TictactoeAppRunnerTest {
    Logger appLogger = (Logger) LoggerFactory.getLogger(TictactoeApp.class);
    ListAppender<ILoggingEvent> listAppender;

    @AfterEach
    public void restoreSystemInput() {
        System.setIn(System.in);
    }

    @Test
    void shouldCompleteWithMockInput() {
        listAppender = new ListAppender<>();
        listAppender.start();
        appLogger.addAppender(listAppender);
        setInput("1,1\n2,1\n2,3\n1,3\n3,3\n2,2\n1,2\n3,2\n3,1\nN\n");
        TictactoeAppRunner.main(new String[]{});
        List<ILoggingEvent> logsList = listAppender.list;
        org.assertj.core.api.Assertions.assertThat(listAppender.list)
                .extracting(ILoggingEvent::getFormattedMessage)
                .contains(DRAW.getValue());

    }

    private void setInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}
