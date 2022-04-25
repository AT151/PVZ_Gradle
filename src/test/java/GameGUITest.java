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
import sample.Level;
import sample.Login;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.base.NodeMatchers.isInvisible;
import static org.testfx.matcher.base.NodeMatchers.isVisible;
import static org.testfx.matcher.control.LabeledMatchers.hasText;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@ExtendWith(ApplicationExtension.class)
public class GameGUITest {

    Stage bigStage;
    Level l;
    int maxX;
    int maxY;

    @Start
    void onStart(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Game.fxml"));

        Parent root = loader.load();

        stage.show();
        l=loader.getController();
        l.set_window(stage);
        l.set_level(1);
        l.set_root(root);
        l.startGame();
    }

    @Test
    void testHasLawn() {
        verifyThat("#zombie1", isVisible());
    }

    @Test
    void testHasPeashooter_menu() {
        verifyThat("#peashooter_menu", isVisible());
    }

    @Test
    void testHasSunflower_menu() {
        verifyThat("#sunflower_menu", isVisible());
    }

    @Test
    void testHasWalnut_menu() {
        verifyThat("#walnut_menu", isVisible());
    }

    @Test
    void testHasCherrybomb_menu() {
        verifyThat("#cherrybomb_menu", isVisible());
    }

    @Test
    void testPeashooter_lock(FxRobot robot) {
        verifyThat("#peashooter_lock", isInvisible());
        robot.sleep(10, TimeUnit.SECONDS);
        collectSun(robot);
        robot.clickOn("#peashooter_menu");
        robot.clickOn(200,200);
        verifyThat("#peashooter_lock", isVisible());
    }

    @Test
    void testSunflower_lock(FxRobot robot) {
        verifyThat("#sunflower_lock", isInvisible());
    }

    @Test
    void testWalnut_lock(FxRobot robot) {
        verifyThat("#walnut_lock", isInvisible());
    }

    @Test
    void testCherrybomb_lock(FxRobot robot) {
        verifyThat("#cherrybomb_lock", isInvisible());
    }

    @Test
    void testLost(FxRobot robot){

        verifyThat("#lost", isInvisible());
        robot.sleep(60, TimeUnit.SECONDS);
        verifyThat("#lost", isVisible());
    }

    @Test
    void testSunCounter() {
        verifyThat("#sun_counter", isVisible());
        verifyThat("#sun_counter", hasText("0"));

    }

    @Test
    void testBar_zombie() {

    }

    @Test
    void testMenu() {

    }

    private void collectSun(FxRobot robot) {
        for (int i = 0; i < 1000; i+=20) {
            for (int j = 0; j < 1000; j+=20) {
                robot.clickOn(i,j);
            }
        }
    }

}
