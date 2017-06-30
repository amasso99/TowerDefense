package Model.GameCore.GameObject;

import java.awt.*;

/**
 * Created by 204g07 on 02.06.2017.
 */
public class Unit extends GeneralGameObject{

    private UnitType type;
    private Image img;

    public Unit(UnitType type){
        super(type.getStats());
        this.type = type;
        img = type.getImage();
    }

    @Override
    public void draw(Graphics2D g2d, int x, int y) {
        g2d.drawImage(img,x,y,null);
    }


}
