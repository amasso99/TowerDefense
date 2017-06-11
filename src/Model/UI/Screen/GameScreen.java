package Model.UI.Screen;

import Control.ScreenController;
import Model.UI.ActionEvent;
import View.Panel.DrawingPanel;

import java.awt.*;

/**
 * Created by Oussama on 11.06.2017.
 */
public class GameScreen extends DrawingPanel implements ActionEvent {

    private Font f;
    private ScreenController screens;

    public GameScreen(ScreenController screenController){
        this.screens = screenController;

        f = new Font("Arial", Font.PLAIN,50);
        initAndAddObjects();
    }

    private void initAndAddObjects() {

    }

    @Override
    public void doAction(String id) {
        switch (id){
        }
    }

}
