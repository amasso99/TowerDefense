package Model.GameCore.GameObject;

import Model.Constants;

import java.awt.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by 204g07 on 02.06.2017.
 */
public enum UnitType { //attack,range,health,attackSpeed,speed,armor,ground,aimsGround,level,price. level 0 = locked
    KNIGHT(new Statistics(10,200,1.0,1.0,1.6,100), Paths.get("media/knight.png")),
    ARCHER(new Statistics(20,600,1.3,1.0,1.2,120), Paths.get("media/archer.png")),
    WIZARD(new Statistics(30,400,1.0,0.8,1.3,150), Paths.get("media/wizard.png")),
    CAVALIER(new Statistics(50,200,1.3,1.2,1.5,600), Paths.get("media/cavalier.png")),
    DRAGON(new Statistics(40,300,1.4,1.1,1.1,500), Paths.get("media/dragon.png")),
    GIANT(new Statistics(3,100,1.6,0.6,1.4,300), Paths.get("media/giant.png"));

    private Statistics stats;
    private Image img;

    UnitType(Statistics stats,Path path){
        this.stats = stats;
        img = Constants.readImageSave(path);
    }

    public Statistics getStats() {
        return stats;
    }

    public Image getImage(){
        return img;
    }

    @Override
    public String toString(){
        return this.name();
    }
}
