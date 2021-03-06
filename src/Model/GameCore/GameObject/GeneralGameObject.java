package Model.GameCore.GameObject;

import java.awt.*;

/**
 * Created by 204g07 on 02.06.2017.
 */
public abstract class GeneralGameObject {
    protected Statistics statistics;

    public GeneralGameObject(Statistics statistics){
        this.statistics = statistics;
    }

    public Statistics getStats() {
        return statistics;
    }

    public abstract void draw(Graphics2D g2d, int x, int y);

    public void rangeAlert(GeneralGameObject gameObject){
    }
}
