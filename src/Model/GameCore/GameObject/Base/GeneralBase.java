package Model.GameCore.GameObject.Base;

import Model.GameCore.GameObject.GeneralGameObject;
import Model.GameCore.GameObject.Statistics;

import java.awt.*;

/**
 * Created by 204g07 on 02.06.2017.
 */
public class GeneralBase extends GeneralGameObject{

    private Statistics stats;

    public GeneralBase(){

    }

    @Override
    public void draw(Graphics2D g2d, int rowX, int rowY) {
        g2d.fillRect(rowX,rowY,50,50);
    }
}
