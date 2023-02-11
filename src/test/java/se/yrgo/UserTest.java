package se.yrgo;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Member;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    @Test
    public void createValidNameTest() {
        User user1 = new User("lixiaoyan", "123456@qq.com");
        assertEquals("lixiaoyan" ,user1.getName());
    }

    @Test
    public void createNullNameTest() {
        assertThrows(IllegalArgumentException.class, () -> new User(null, "*@*"));
    }


    @Test
    void createUserWithValidEmailTest() {
        User testUser = new User("Eva", "eva@gmail.com");
        assertEquals("Eva", testUser.getName());
    }

    @Test
    void createUserWithInvalidEmailTest() {
        User testUser;
        assertThrows(IllegalArgumentException.class, () -> new User("Ben", "benAtgamil.com"));
    }
}
