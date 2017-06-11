package Model.UI.Screen;

import Control.ScreenController;
import Model.UI.ActionEvent;
import Model.UI.Button;
import View.Panel.DrawingPanel;

import java.awt.*;

/**
 * Created by Oussama on 02.06.2017.
 */
public class MainScreen extends DrawingPanel implements ActionEvent {

    private Font f;
    private ScreenController screens;

    public MainScreen(ScreenController screenController){
        this.screens = screenController;

        f = new Font("Arial", Font.PLAIN,50);
        initAndAddObjects();
    }

    private void initAndAddObjects() {
        Button btnExit = new Button("Exit",screenWidth*0.2,screenHeight*0.6,screenWidth*0.6,screenHeight*0.1,"exit",f);
        btnExit.setActionListener(this);
        addObject(btnExit);

        Button btnStart = new Button("Start",screenWidth*0.2,screenHeight*0.3,screenWidth*0.6,screenHeight*0.1,"start",f);
        btnStart.setActionListener(this);
        addObject(btnStart);

    }

    @Override
    public void doAction(String id) {
        switch (id){
            case("start"):
                screens.switchScreen(ScreenController.Type.GAME_SCREEN);
                break;
            case("exit"):
                System.exit(0);
                break;
        }
    }
}
