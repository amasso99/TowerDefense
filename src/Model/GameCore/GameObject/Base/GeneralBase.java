package Model.GameCore.GameObject.Base;

import Model.Constants;
import Model.GameCore.GameObject.GeneralGameObject;
import Model.GameCore.GameObject.Statistics;
import Model.GameCore.GameObject.UnitType;

import java.awt.*;

/**
 * Created by 204g07 on 02.06.2017.
 */
public class GeneralBase extends GeneralGameObject{

    private int x,y;

    public GeneralBase(Statistics statistics){
        super(statistics);
        x = 0;
        y = 0;

    }

    public GeneralBase() {
        super(UnitType.ARCHER.getStats());
    }

    @Override
    public void draw(Graphics2D g2d, int rowX, int rowY) {
        g2d.fillRect(rowX,rowY, Constants.TOWER_IMG_WIDTH,Constants.TOWER_IMG_HEIGHT);
        if(x == 0 || y == 0){
            x = rowX +Constants.TOWER_IMG_WIDTH / 2;
            y = rowY +Constants.TOWER_IMG_HEIGHT / 2;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
