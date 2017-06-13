package Model.UI.Screen;

import Control.ScreenController;
import Model.UI.ActionEvent;
import Model.UI.Button;
import Model.UI.Label;
import View.Panel.DrawingPanel;
import java.awt.Font;

import java.awt.*;

/**
 * Created by Oussama on 02.06.2017.
 */
public class MainScreen extends DrawingPanel implements ActionEvent {

    private Font f;
    private ScreenController screenController;

    public MainScreen(ScreenController screenController){
        this.screenController = screenController;

        f = new Font("Arial", Font.PLAIN,32);
        initAndAddObjects();
    }

    private void initAndAddObjects() {
        int btnWidth = (int) (screenWidth*0.7);
        int btnHeight = (int) (screenHeight*0.1);

        Button btnStart = new Button("Start", (int) (screenWidth*0.5-btnWidth/2), (int) (screenHeight*0.2),btnWidth,btnHeight,"start",f);
        btnStart.setActionListener(this);
        addObject(btnStart);

        Button btnExit = new Button("Exit", (int) (screenWidth*0.5-btnWidth/2), (int) (screenHeight*0.6),btnWidth,btnHeight,"exit",f);
        btnExit.setActionListener(this);
        addObject(btnExit);
    }

    @Override
    public void doAction(String id) {
        switch(id){
            case("start"):
                screenController.switchScreen(ScreenController.Type.GAME_SCREEN);
                break;
            case("exit"):
                System.exit(0);
                break;
        }
    }
}
