package Model.GameCore.GameObject.Base;

import Model.GameCore.GameObject.GeneralGameObject;
import Model.GameCore.GameObject.Statistics;

import java.awt.*;

/**
 * Created by 204g07 on 02.06.2017.
 */
public class GeneralBase extends GeneralGameObject{

    private Statistics stats;
    private int x,y;

    public GeneralBase(){

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void draw(Graphics2D g2d, int rowX, int rowY) {
        g2d.drawRect(rowX,rowY,50,50);
    }
}
