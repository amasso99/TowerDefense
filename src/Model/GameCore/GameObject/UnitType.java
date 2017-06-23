package Model.GameCore.GameObject;

/**
 * Created by 204g07 on 02.06.2017.
 */
public enum UnitType { //attack,range,health,attackSpeed,speed,armor,ground,aimsGround,level,mana. level 0 = locked
    KNIGHT(new Statistics(10,1,200,2,4,1.6,true,true,0,100)),
    ARCHER(new Statistics(20,6,30,2,3,1.2,true,false,0,120)),
    WIZARD(new Statistics(30,4,50,4,6,1.3,true,false,0,150)),
    CAVALIER(new Statistics(50,2,300,3,1,1.5,true,true,0,600)),
    DRAGON(new Statistics(40,3,500,5,5,1.1,false,false,0,500)),
    GIANT(new Statistics(3,1,1000,5,8,1.4,true,true,0,300));

    Statistics stats;

    UnitType(Statistics stats){
        this.stats = stats;
    }

    public Statistics getStats() {
        return stats;
    }
}
