package se.yrgo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SubTest {
    @Test
    public void testCreateValidSub() {
        Sub test = new Sub("Test");
        assertEquals("Test", test.getTitle());
    }

    @Test
    public void testCreateInvalidSub() {
        assertThrows(IllegalArgumentException.class, () -> new Sub("    "));
    }

    @Test
    public void testAddThread() {
        Sub subTest = new Sub("TestSub");
        User userTest = new User("TestUser", "test@gmail.com");
        Thread threadTest = new Thread("ThreadTest", userTest);
        subTest.addThread(threadTest);
        assertEquals(1, subTest.numberOfThread());
    }

    @Test
    public void testAddInvalidThread() {
        Sub test = new Sub("Test");
        User userTest = new User("TestUser", "test@gmail.com");
        assertThrows(IllegalArgumentException.class, () -> test.addThread(new Thread("  ", userTest)));
    }

    @Test
    public void testThreadFound() throws ThreadNotFoundException {
        Sub subTest = new Sub("TestSub");
        User userTest = new User("TestUser", "test@gmail.com");
        Thread threadTest = new Thread("ThreadTest", userTest);
        subTest.addThread(threadTest);
        Thread foundThread = subTest.findThread("ThreadTest");
        assertEquals("ThreadTest", foundThread.getTitle());
    }

    @Test
    public void testThreadNotFound() {
        Sub test = new Sub("Test");
        assertThrows(ThreadNotFoundException.class, () -> test.findThread("Should not exist"));
    }
}
