package Model.GameCore;

import Model.DataStructure.Extended.Graph;
import Model.GameCore.GameObject.Base.GeneralBase;

/**
 * Created by 204g07 on 02.06.2017.
 */
public class Map {

    Graph map;

    public Map(){
        map = new Graph<GeneralBase,Lane>();

    }
}
