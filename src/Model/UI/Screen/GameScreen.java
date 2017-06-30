package Model.UI.Screen;

import Control.ScreenController;
import Model.DataStructure.List;
import Model.GameCore.GameMap;
import Model.GameCore.GameObject.GeneralBase;
import Model.GameCore.GameObject.UnitType;
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
        buildMap();
        gameMap.summonUnit(UnitType.ARCHER);
    }

    private void initAndAddObject() {
        gameMap = new GameMap(screenWidth*0.95,screenHeight*0.75,0.025*screenWidth,0.05*screenHeight);
        addObject(gameMap);
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
}
