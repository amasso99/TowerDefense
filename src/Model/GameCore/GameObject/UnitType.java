package Model.GameCore.GameObject;

/**
 * Created by 204g07 on 02.06.2017.
 */
public enum UnitType { //attack,range,health,attackSpeed,speed,armor,ground,aimsGround,level,price. level 0 = locked
    KNIGHT(new Statistics(10,200,1.0,1.0,1.6,100)),
    ARCHER(new Statistics(20,600,1.3,1.0,1.2,120)),
    WIZARD(new Statistics(30,400,1.0,0.8,1.3,150)),
    CAVALIER(new Statistics(50,200,1.3,1.2,1.5,600)),
    DRAGON(new Statistics(40,300,1.4,1.1,1.1,500)),
    GIANT(new Statistics(3,100,1.6,0.6,1.4,300));

    Statistics stats;

    UnitType(Statistics stats){
        this.stats = stats;
    }

    public Statistics getStats() {
        return stats;
    }
}
