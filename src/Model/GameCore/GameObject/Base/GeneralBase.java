package Model.GameCore.GameObject.Base;

import Model.Constants;
import Model.GameCore.GameObject.GeneralGameObject;
import Model.GameCore.GameObject.Statistics;

import java.awt.*;

/**
 * Created by 204g07 on 02.06.2017.
 */
public class GeneralBase extends GeneralGameObject{


    public GeneralBase(Statistics statistics){
        super(statistics);

    }

    @Override
    public void draw(Graphics2D g2d, int rowX, int rowY) {
        g2d.fillRect(rowX,rowY, Constants.TOWER_IMG_WIDTH,Constants.TOWER_IMG_HEIGHT);
    }
}
