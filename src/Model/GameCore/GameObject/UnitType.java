package Model.GameCore.GameObject;

/**
 * Created by 204g07 on 02.06.2017.
 */
public enum UnitType {
    KNIGHT(new Statistics(10,10,100,10,10,10,true,true,1)),
    ARCHER(new Statistics(10,10,100,10,10,10,true,false,1)),
    WIZARD(new Statistics(10,10,100,10,10,10,true,false,1)),
    CAVALIER(new Statistics(10,10,100,10,10,10,true,true,1)),
    DRAGON(new Statistics(10,10,100,10,10,10,false,false,1)),
    GIANT(new Statistics(10,10,100,10,10,10,true,true,1));

    Statistics stats;

    UnitType(Statistics stats){
        this.stats = stats;
    }
}