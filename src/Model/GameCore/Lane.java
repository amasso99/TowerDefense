package Model.GameCore;

import Model.DataStructure.Queue;
import Model.GameCore.GameObject.Unit;

import static Model.Constants.MOVING_TIME;

/**
 * Created by 204g07 on 09.06.2017.
 */
public class Lane implements Comparable<Lane> {

    private double timer;
    private final int wayLength;
    private Queue<Unit>queue;
    private boolean attackable;


    public Lane(int wayLength){
        this.wayLength = wayLength;
        timer = 0;
        queue = new Queue<Unit>();
    }

    public void join(Unit unit){
        queue.enqueue(unit);
    }

    public void update(double dt){
        if(!queue.isEmpty()) {
            timer = dt + timer;
            System.out.println(timer);
            if (timer >= MOVING_TIME * (queue.front().getStats().getSpeed())) {
                attackable = true;
                timer = 0;
            }
        }
    }

    @Override
    public int compareTo(Lane o) {
        if(o.getWayLength() < getWayLength()){
            return 1;
        }
        if(o.getWayLength() > getWayLength()){
            return -1;
        }
        if(o.getWayLength() == getWayLength()){
            return 0;
        }
        return -1;
    }

    public int getWayLength(){
        return wayLength;
    }

    public Unit getAttackableUnit(){
        if(attackable){
            attackable = false;
            return queue.front();
        }
        return null;
    }
}
