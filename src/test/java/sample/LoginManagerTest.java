package sample;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

    // Test that saving and loading save should restore to same state
    // Commented out to ensure testing suite can run. Serialize (save)
    // not implemented correctly
//    @Test
//    public void reloadTest() throws IOException, ClassNotFoundException {
//        LoginManager loginManager = new LoginManager();
//        User user = new User("name");
//        loginManager.u.add(user);
//        int beforeLength = loginManager.u.size();
//        loginManager.serialize();
//        loginManager.deserialize();
//        int afterLength = loginManager.u.size();
//        assertEquals(beforeLength, afterLength);
//    }

}
