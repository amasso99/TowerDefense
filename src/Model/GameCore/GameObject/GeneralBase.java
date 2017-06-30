package Model.GameCore.GameObject;

import Model.Constants;

import java.awt.*;
import java.nio.file.Paths;

/**
 * Created by 204g07 on 02.06.2017.
 */
public class GeneralBase extends GeneralGameObject{

    private int x,y;

    private Image img;

    public GeneralBase() {
        super(new Statistics(40,300,0.8,0,30,0));
        x = 0;
        y = 0;
        img = Constants.readImageSave(Paths.get("media/tower.png"));
    }


    @Override
    public void draw(Graphics2D g2d, int rowX, int rowY) {
        double h = getStats().getHealthInPercent();
        Color color;
        if(h > 0.75){
            color = new Color(0, 255, 15, 30);
        }else if(h > 0.4){
            color = new Color(255, 200, 3,30);
        }else{
            color = new Color(255, 3,0,30);
        }
        g2d.setColor(color);
        g2d.fillRect(rowX,rowY,Constants.TOWER_IMG_WIDTH,Constants.TOWER_IMG_HEIGHT);
        g2d.drawImage(img,rowX,rowY,null);

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
