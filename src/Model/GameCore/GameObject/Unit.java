package Model.GameCore.GameObject;

/**
 * Created by 204g07 on 02.06.2017.
 */
public class Unit {

    private UnitType type;

    public Unit(UnitType type){
        this.type = type;

    }

    public Statistics getStatistics(){
        return type.getStats();
    }
}
