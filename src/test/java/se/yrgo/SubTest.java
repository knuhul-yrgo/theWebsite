package se.yrgo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class SubTest {
    @Test
    public void testThreadNotFound() throws SubTitleEmptyException {
        Sub test = new Sub("Test");
        assertThrows(ThreadNotFoundException.class, () ->test.findThread("Should not exist"));
    }
    @Test
    public void testSubNameNotEmpty() throws SubTitleEmptyException {
        Sub emptyTitle = new Sub("  ");
        assertThrows(SubTitleEmptyException.class, emptyTitle::getTitle);
    }
}
