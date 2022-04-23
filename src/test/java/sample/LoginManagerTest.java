package sample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginManagerTest {
    @Test
    public void loadTest() throws IOException, ClassNotFoundException {
        LoginManager loginManager = new LoginManager();

        int beforeLength = loginManager.u.size();


        loginManager.deserialize();



        int afterLength = loginManager.u.size();


        assertTrue(afterLength > beforeLength);

    }

}
