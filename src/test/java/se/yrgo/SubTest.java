package se.yrgo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class SubTest {
    @Test
    public void testThreadNotFound(){
        Sub test = new Sub("Test");
        assertThrows(ThreadNotFoundException.class, () ->test.findThread("Should not exist"));
    }
}
