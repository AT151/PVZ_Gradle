package sample;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class UserTest {
    @Test
    public void initializeUser(){

        User user = new User("Crazy Dave");
        assertEquals(user.getName(), "Crazy Dave");
        assertEquals(user.toString(), "Crazy Dave");
    }
}
