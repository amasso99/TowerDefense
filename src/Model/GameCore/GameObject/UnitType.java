package Model.GameCore.GameObject;

/**
 * Created by 204g07 on 02.06.2017.
 */
public enum UnitType { //attack,range,health,attackSpeed,speed,armor,ground,aimsGround,level,mana. level 0 = locked
    KNIGHT(new Statistics(10,1,200,1.0,1.6,0,100)),
    ARCHER(new Statistics(20,6,30,1.0,1.2,0,120)),
    WIZARD(new Statistics(30,4,50,0.8,1.3,0,150)),
    CAVALIER(new Statistics(50,2,300,1.2,1.5,0,600)),
    DRAGON(new Statistics(40,3,500,1.1,1.1,0,500)),
    GIANT(new Statistics(3,1,1000,0.6,1.4,0,300));

    Statistics stats;

    UnitType(Statistics stats){
        this.stats = stats;
    }

    public Statistics getStats() {
        return stats;
    }
}
