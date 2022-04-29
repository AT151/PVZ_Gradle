import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.api.FxRobot;
import sample.Level;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.base.NodeMatchers.isInvisible;
import static org.testfx.matcher.base.NodeMatchers.isVisible;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@ExtendWith(ApplicationExtension.class)
public class GameGUITest {

    Stage bigStage;
    Level l;
    int maxX = 950;
    int maxY = 600;

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
        robot.sleep(5, TimeUnit.SECONDS);
        collectSun(robot);
        robot.clickOn("#peashooter_menu");
        robot.clickOn(300,200);
        verifyThat("#peashooter_lock", isVisible());
    }

    @Test
    void testSunflower_lock(FxRobot robot) {
        verifyThat("#sunflower_lock", isInvisible());
        robot.sleep(5, TimeUnit.SECONDS);
        collectSun(robot);
        robot.clickOn("#sunflower_menu");
        robot.clickOn(300,200);
        verifyThat("#sunflower_lock", isVisible());
    }

    @Test
    void testWalnut_lock(FxRobot robot) {
        verifyThat("#walnut_lock", isInvisible());
        robot.sleep(5, TimeUnit.SECONDS);
        collectSun(robot);
        robot.clickOn("#walnut_menu");
        robot.clickOn(300,200);
        verifyThat("#walnut_lock", isVisible());
    }

    @Test
    void testCherrybomb_lock(FxRobot robot) {
        verifyThat("#cherrybomb_lock", isInvisible());
        robot.sleep(10, TimeUnit.SECONDS);
        collectSun(robot);
        robot.clickOn("#cherrybomb_menu");
        robot.clickOn(300,200);
        verifyThat("#cherrybomb_lock", isVisible());
    }

    @Test
    void testLost(FxRobot robot){

        verifyThat("#lost", isInvisible());
        robot.sleep(60, TimeUnit.SECONDS);
        verifyThat("#lost", isVisible());
    }

    @Test
    void testSunCounter(FxRobot robot) {
        verifyThat("#sun_counter", isVisible());
        collectSun(robot);
        verifyThat("#sun_counter", (TextField t) -> Integer.parseInt(t.getText()) > 0);

    }

    @Test
    void testMenu(FxRobot robot) {
        verifyThat("#menu_pane", isInvisible());
        robot.clickOn("#menu_button");
        verifyThat("#menu_pane", isVisible());
        robot.clickOn("#resume");
        verifyThat("#menu_pane", isInvisible());
        robot.clickOn("#menu_button");
        robot.clickOn("#exit_button");


    }

    private void collectSun(FxRobot robot) {
        for (int i = 300; i < maxX; i+=50) {
            for (int j = 100; j < maxY; j+=50) {
                robot.clickOn(i,j);

            }
        }
    }

}
