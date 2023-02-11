package se.yrgo;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ThreadTest {
    @Test
    public void createThreadWithValidTitle() {
        Thread threadTest = new Thread("Discussion", new User("test", "test@test.com"));
        assertEquals("Discussion", threadTest.getTitle());
    }

    @Test
    public void createThreadWithInvalidTitle() {
        assertThrows(IllegalArgumentException.class, () -> new Thread("  ",
                new User("test", "test@test.com")));
    }

    @Test
    public void addValidComment() {
        Thread threadTest = new Thread("Discussion", new User("test", "test@test.com"));
        threadTest.addComment(new User("test", "test@test.com"), "comment");
        assertEquals(1, threadTest.numberOfComments());
    }

    @Test
    public void addInvalidComment() {
        Thread threadTest = new Thread("Discussion", new User("test", "test@test.com"));
        assertThrows(IllegalArgumentException.class, () -> threadTest.addComment(null, "comment"));
    }

    @Test
    public void readCommentsTest() {
        Thread threadTest = new Thread("Discussion", new User("test", "test@test.com"));
        threadTest.addComment(new User("test", "test@test.com"), "comment");
        assertEquals("[test (test@test.com):\n" +
        "comment\n" + LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES).toString() +
        "]", threadTest.getComments().toString());
    }
}
