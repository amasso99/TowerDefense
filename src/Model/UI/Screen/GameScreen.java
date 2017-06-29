package Model.UI.Screen;

import Control.ScreenController;
import Model.DataStructure.List;
import Model.GameCore.GameMap;
import Model.GameCore.GameObject.Base.GeneralBase;
import Model.UI.ActionEvent;
import Model.UI.Button;
import View.Panel.DrawingPanel;

import java.awt.*;

/**
 * Created by 204g07 on 12.06.2017.
 */
public class GameScreen extends DrawingPanel implements ActionEvent {

    private ScreenController screenController;
    private GameMap gameMap;
    //private Font f;

    public GameScreen(ScreenController screenController){
        this.screenController = screenController;
        initAndAddObjects();
        buildMap();
        //f = new Font("Arial", Font.PLAIN,32);
    }

    private void initAndAddObjects() {
        gameMap = new GameMap(screenWidth*0.95,screenHeight*0.75,0.025*screenWidth,0.05*screenHeight);
        addObject(gameMap);

        /*
        int btnWidth = (int) (screenWidth*0.7);
        int btnHeight = (int) (screenHeight*0.1);
        Button btnBack = new Button("Back", (int) (screenWidth*0.5-btnWidth/2), (int) (screenHeight*0.7), btnWidth, btnHeight, "back", f);
        btnBack.setActionListener(this);
        addObject(btnBack);
        */
    }

    private void buildMap(){
        List<GeneralBase> base = new List<>();
        base.append(new GeneralBase());
        gameMap.addBaseRow(base);

        List<GeneralBase> base2 = new List<>();
        base2.append(new GeneralBase());
        base2.append(new GeneralBase());
        gameMap.addBaseRow(base2);

        List<GeneralBase> base3 = new List<>();
        base3.append(new GeneralBase());
        base3.append(new GeneralBase());
        gameMap.addBaseRow(base3);

        List<GeneralBase> base4 = new List<>();
        base4.append(new GeneralBase());
        gameMap.addBaseRow(base4);


        base.toFirst();

        base2.toFirst();
        gameMap.addLane(base.getContent(),base2.getContent(),6);
        base2.next();
        gameMap.addLane(base.getContent(),base2.getContent(),6);

        base3.toFirst();
        base2.toFirst();
        gameMap.addLane(base2.getContent(),base3.getContent(),6);
        base3.next();
        base2.next();
        gameMap.addLane(base2.getContent(),base3.getContent(),6);

        base4.toFirst();
        base3.toFirst();
        gameMap.addLane(base4.getContent(),base3.getContent(),6);
        base3.next();
        gameMap.addLane(base4.getContent(),base3.getContent(),6);

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
