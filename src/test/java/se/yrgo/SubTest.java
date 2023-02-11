package se.yrgo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class SubTest {
    @Test
    public void testThreadNotFound() throws TitleEmptyException {
        Sub test = new Sub("Test");
        assertThrows(ThreadNotFoundException.class, () ->test.findThread("Should not exist"));
    }
    @Test
    public void testSubNameNotEmpty() throws TitleEmptyException {
        Sub emptyTitle = new Sub("  ");
        assertThrows(TitleEmptyException.class, emptyTitle::getTitle);
    }

}
