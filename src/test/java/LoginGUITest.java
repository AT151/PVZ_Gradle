import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.api.FxRobot;
import sample.Login;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.base.NodeMatchers.isInvisible;
import static org.testfx.matcher.base.NodeMatchers.isVisible;
import static org.testfx.matcher.control.LabeledMatchers.hasText;

import java.io.IOException;
import java.util.ArrayList;

@ExtendWith(ApplicationExtension.class)
public class LoginGUITest {
    Parent root;

    @Start
    void onStart(Stage stage) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/Login.fxml"));
        stage.setScene(new Scene(root,950,600));
        stage.show();
    }

    @Test
    void testHasNewUserButton() {
        verifyThat("#newu", hasText("New User"));
    }

    @Test
    void testHasExistingUserButton() {
        verifyThat("#existingu", hasText("Existing User"));
    }

    @Test
    void testHasExitButton() {
        verifyThat("#exit", hasText("Exit"));
    }

    @Test
    void testPressNewUser(FxRobot robot) {
        verifyThat("#pane", isInvisible());
        robot.clickOn("#newu");
        verifyThat("#pane", isVisible());
    }

    @Test
    void testPressNewUserThenCancel(FxRobot robot) {
        robot.clickOn("#newu");
        verifyThat("#pane", isVisible());
        robot.clickOn("CANCEL");
        verifyThat("#pane", isInvisible());
    }

    @Test
    void testPressNewUserThenSubmitNoText(FxRobot robot) {
        robot.clickOn("#newu");
        verifyThat("#pane", isVisible());
        robot.clickOn("SUBMIT");
        verifyThat("Error: Invalid Username.", isVisible());
    }

    @Test
    void testPressNewUserThenSubmitWithText(FxRobot robot) {
        Scene initScene = root.getScene();
        robot.clickOn("#newu");
        verifyThat("#pane", isVisible());
        robot.clickOn("#tf_input").type(KeyCode.C, KeyCode.O,KeyCode.C, KeyCode.K);
        robot.clickOn("SUBMIT");
    }

    @Test
    void testPressExistingUserNoExistingUsers(FxRobot robot) {
        robot.clickOn("#existingu");
        verifyThat("No User Saved Currently", isVisible());
        robot.clickOn("OK");
    }

    @Test
    void testPressExit(FxRobot robot) {
        robot.clickOn("#exit");
        verifyThat("Do you want to exit the game?", isVisible());
        verifyThat("Yes", isVisible());
        verifyThat("No", isVisible());
        robot.clickOn("No");
    }

}
