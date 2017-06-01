package Control;

import Model.UI.Screen.MainScreen;
import View.MainFrame;

/**
 * Created by Oussama on 02.06.2017.
 */
public class ScreenController {
    private MainController mainController;
    private MainFrame frame;

    private MainScreen mainScreen;

    public ScreenController(MainController mainController){
        this.mainController = mainController;
        frame = mainController.getFrame();

        createScreen();
        frame.setContentPanel(mainScreen);
    }

    private void createScreen() {
        mainScreen = new MainScreen();
    }

}
