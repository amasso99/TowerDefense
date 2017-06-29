package Model.UI.Screen;

import Control.ScreenController;
import Model.UI.ActionEvent;
import Model.UI.Popup;
import View.Panel.DrawingPanel;
import Model.UI.Button;
import java.awt.Font;

/**
 * Created by Alex on 23.06.2017.
 */
public class SettingScreen extends DrawingPanel implements ActionEvent{

    private Font f;
    private ScreenController screenController;

    public SettingScreen (ScreenController screenController){
        this.screenController = screenController;

        f = new Font("Arial", Font.PLAIN,32);
        initAndAddObjects();
    }

    public void initAndAddObjects() {
        int btnWidth = (int) (screenWidth*0.7);
        int btnHeight = (int) (screenHeight*0.1);

        Button btnBack = new Button("Back", (int) (screenWidth*0.5-btnWidth/2), (int) (screenHeight*0.7), btnWidth, btnHeight, "back", f);
        btnBack.setActionListener(this);
        addObject(btnBack);

        Popup pop = new Popup(100,100,"+100$",f, 0,255,0);
        addObject(pop);
    }

    @Override
    public void doAction(String id) {
        switch(id){
            case("back"):
                screenController.switchScreen(ScreenController.Type.MAIN_SCREEN);
                break;
        }
    }
}
