package se.yrgo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {

    @Test
    public void createUser() {
        User user = new User("lixiaoyan", "123456@qq.com");
    }

}
