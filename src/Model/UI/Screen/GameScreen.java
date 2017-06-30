package Model.UI.Screen;

import Control.ScreenController;
import Model.DataStructure.List;
import Model.GameCore.GameMap;
import Model.GameCore.GameObject.GeneralBase;
import Model.GameCore.GameObject.UnitType;
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

    public GameScreen(ScreenController screenController){
        this.screenController = screenController;
        initAndAddObject();
        buildMap();
    }

    private void initAndAddObject() {
        gameMap = new GameMap(screenWidth*0.95,screenHeight*0.75,0.025*screenWidth,0.05*screenHeight);
        addObject(gameMap);

        UnitType[]types = UnitType.values();
        int offsetY = (int) (screenHeight*0.8);
        int offsetX = (int) (0.025*screenWidth);

        int width = (int) (screenWidth*0.95);
        int btnWidth = width/ types.length;
        int btnHeight = (int) (screenHeight*0.1);
        Font f = new Font("Arial", Font.PLAIN, 32);
        for (int i = 0; i < types.length; i++) {
            Button btn = new Button(types[i].toString(),offsetX,offsetY,btnWidth,btnHeight,types[i].toString(),f);
            btn.setActionListener(this);
            addObject(btn);
            offsetX = offsetX + btnWidth;
            if(i == 2){
                offsetX = (int) (0.025*screenWidth);
                offsetY = offsetY + btnHeight;
            }
        }

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

    }

    @Override
    public void doAction(String id) {
        gameMap.summonUnit(UnitType.valueOf(id));
    }
}
