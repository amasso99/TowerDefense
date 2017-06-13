package Model.UI.Screen;

import Control.ScreenController;
import Model.DataStructure.List;
import Model.GameCore.GameMap;
import Model.GameCore.GameObject.Base.GeneralBase;
import View.Panel.DrawingPanel;

/**
 * Created by 204g07 on 12.06.2017.
 */
public class GameScreen extends DrawingPanel {

    private ScreenController screenController;
    private GameMap gameMap;

    public GameScreen(ScreenController screenController){
        this.screenController = screenController;
        initAndAddObject();
    }

    private void initAndAddObject() {
        gameMap = new GameMap(screenWidth*0.95,screenHeight*0.75,0.025*screenWidth,0.05*screenHeight);
        addObject(gameMap);

        List<GeneralBase> base = new List<>();
        base.insert(new GeneralBase());
        base.insert(new GeneralBase());
        gameMap.addBaseRow(base);

        base = new List<>();
        base.insert(new GeneralBase());
        base.insert(new GeneralBase());
        base.insert(new GeneralBase());
        gameMap.addBaseRow(base);


        base = new List<>();
        base.insert(new GeneralBase());
        gameMap.addBaseRow(base);

    }
}
