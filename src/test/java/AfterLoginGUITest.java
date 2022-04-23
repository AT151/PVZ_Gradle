import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
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
public class AfterLoginGUITest {


    @Start
    void onStart(Stage stage) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/AfterLogin.fxml"));
        Parent root = loader.load();
        stage.setScene(new Scene(root,950,600));
        stage.show();
    }

    @Test
    void testHasNewGameButton() {
        verifyThat("#newg", hasText("Start New Game"));
    }

    @Test
    void testPressNewGameButton(FxRobot robot) {
        robot.clickOn("#newg");
    }

    @Test
    void testHasLoadGameButton() {
        verifyThat("#load", hasText("Load Saved Game"));
    }

    @Test
    void testPressLoadGameButton(FxRobot robot) {
        verifyThat("#pane", isInvisible());
        robot.clickOn("#load");
        verifyThat("#pane", isVisible());
    }

    @Test
    void testPressLoadGameButtonThenBack(FxRobot robot) {
        verifyThat("#pane", isInvisible());
        robot.clickOn("#load");
        verifyThat("#pane", isVisible());
        robot.clickOn("#back_button");
        verifyThat("#pane", isInvisible());
    }

    @Test
    void testHasChooseLevelButton() {
        verifyThat("#choose", hasText("Choose Level"));
    }

    @Test
    void testPressChooseLevelButton(FxRobot robot) {
        robot.clickOn("#choose");
        verifyThat("Select a Level", isVisible());
        robot.clickOn("Cancel");
    }

    @Test
    void testPressChooseLevelButtonThenOk(FxRobot robot) {
        robot.clickOn("#choose");
        verifyThat("Select a Level", isVisible());
        robot.clickOn("OK");
    }

    @Test
    void testPressChooseLevelButtonChooseLevel2ThenOk(FxRobot robot) {
        robot.clickOn("#choose");
        robot.clickOn("1");
        robot.clickOn("2");
        robot.clickOn("OK");
    }

    @Test
    void testPressChooseLevelButtonChooseLevel3ThenOk(FxRobot robot) {
        robot.clickOn("#choose");
        robot.clickOn("1");
        robot.clickOn("3");
        robot.clickOn("OK");
    }

    @Test
    void testPressChooseLevelButtonChooseLevel4ThenOk(FxRobot robot) {
        robot.clickOn("#choose");
        robot.clickOn("1");
        robot.clickOn("4");
        robot.clickOn("OK");
    }

    @Test
    void testPressChooseLevelButtonChooseLevel5ThenOk(FxRobot robot) {
        robot.clickOn("#choose");
        robot.clickOn("1");
        robot.clickOn("5");
        robot.clickOn("OK");
    }

    @Test
    void testHasExitButton() {
        verifyThat("#exit", hasText("Exit"));
    }
}
