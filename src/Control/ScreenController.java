package Control;

import Model.UI.Screen.GameScreen;
import Model.UI.Screen.MainScreen;
import Model.UI.Screen.SettingScreen;
import View.MainFrame;

/**
 * Created by Oussama on 02.06.2017.
 */
public class ScreenController {
    public enum Type{
        MAIN_SCREEN(),
        SETTING_SCREEN(),
        GAME_SCREEN();
    }

    private MainController mainController;
    private MainFrame frame;

    private MainScreen mainScreen;
    private SettingScreen settingScreen;
    private GameScreen gameScreen;

    public ScreenController(MainController mainController){
        this.mainController = mainController;
        frame = mainController.getFrame();

        createScreen();
        frame.setContentPanel(mainScreen);
    }

    private void createScreen() {
        mainScreen = new MainScreen(this);
        gameScreen = new GameScreen(this);
        settingScreen = new SettingScreen(this);
    }

    public void switchScreen(Type type){
        switch (type){
            case MAIN_SCREEN:
                frame.setContentPanel(mainScreen);
                break;
            case SETTING_SCREEN:
                frame.setContentPanel(settingScreen);
                break;
            case GAME_SCREEN:
                frame.setContentPanel(gameScreen);
                break;
        }
    }
}
