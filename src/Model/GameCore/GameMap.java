package Model.GameCore;

import Model.Constants;
import Model.DataStructure.Extended.Edge;
import Model.DataStructure.Extended.Graph;
import Model.DataStructure.Extended.Utils;
import Model.DataStructure.Extended.Vertex;
import Model.DataStructure.List;
import Model.GameCore.GameObject.GeneralBase;
import Model.GameCore.GameObject.Unit;
import Model.GameCore.GameObject.UnitType;
import View.Abstraction.ICanvas;
import View.Abstraction.IDrawableObject;

import java.awt.*;

/**
 * Created by 204g07 on 02.06.2017.
 */
public class GameMap implements IDrawableObject{

    private int width;
    private int height;
    private int x;
    private int y;

    private Rectangle rectangle;

    private Graph<GeneralBase,Lane> map;
    private ICanvas canvas;
    private Color color = new Color(0,0,0);

    private List<List<GeneralBase>> alllign;
    private Vertex<GeneralBase> start,end;

    public GameMap(double width, double height, double x, double y){
        this.width = (int) width;
        this.height = (int) height;
        this.x = (int) x;
        this.y = (int) y;

        map = new Graph<>();

        alllign = new List<>();
        rectangle = new Rectangle(this.x,this.y,this.width,this.height);
    }

    public void summonUnit(UnitType type){
        Unit unit = new Unit(type);

        joinRandomLane(start,unit);
    }

    public void joinRandomLane(Vertex vertex,Unit unit){
        List<Edge> list = map.getEdges(vertex);
        if(!list.isEmpty()) {
            int size = Utils.altSize(list);
            size = (int) (Math.random() * size);

            list.toFirst();
            for (int i = 0; i < size; i++) {
                list.next();
            }
            if (!list.hasAccess()) {
                list.toFirst();
            }
            list.toFirst();
            Edge<GeneralBase, Lane> edge = list.getContent();
            edge.getWeight().join(unit);
        }
    }

    public void setStartBase(GeneralBase base){

        this.start = map.getVertex(base);
    }

    public void setEndBase(GeneralBase base){
        this.end = map.getVertex(base);
    }


    public void addBaseRow(List<GeneralBase> bases){
        for (bases.toFirst();bases.hasAccess();bases.next()){
            if(start == null){
                start = new Vertex<>(bases.getContent());
            }
            map.addVertex(new Vertex<>(bases.getContent()));
        }
        alllign.append(bases);
    }

    /**
     * Adds a lane from home to target with a set length.
     * @param home base vertex
     * @param target target vertex
     * @param length length of the lane
     */
    public void addLane(GeneralBase home, GeneralBase target,int length){
        Vertex start = map.getVertex(home);
        Vertex end = map.getVertex(target);
        if(start != null && end != null) {
            Edge<GeneralBase, Lane> edge = new Edge(map.getVertex(home), map.getVertex(target), new Lane(length));
            map.addEdge(edge);
        }
    }

    /**
     * Draws the game map.
     */
    @Override
    public void draw() {
        Graphics2D g2d = canvas.getPencil();
        g2d.setColor(color);
        g2d.draw(rectangle);
        drawBases(g2d);
        drawLanes(g2d);
    }

    private void drawUnits(List<Unit> units, Graphics2D g2d) {
        for (units.toFirst();units.hasAccess();units.next()){

        }

    }

    private void drawBases(Graphics2D g2d) {
        int gapX = (int) (width/ ((double) Utils.altSize(alllign)+1));
        int offSetX = x + gapX;
        for (alllign.toFirst();alllign.hasAccess();alllign.next()){
            List<GeneralBase> list = alllign.getContent();
            int gapY = (int) (height/ ((double) Utils.altSize(list)+1));
            int offSetY = y;
            for (list.toFirst();list.hasAccess();list.next()){
                offSetY = offSetY +  gapY;
                list.getContent().draw(g2d,offSetX- Constants.TOWER_IMG_WIDTH /2, offSetY- Constants.TOWER_IMG_HEIGHT /2);
            }
            offSetX = offSetX + gapX;
        }
    }

    private void drawLanes(Graphics2D g2d) {
        List<Edge<GeneralBase,Lane>> list = map.getEdges();
        for (list.toFirst();list.hasAccess();list.next()){
            Edge<GeneralBase,Lane> edge = list.getContent();
            if(edge != null) {
                Vertex<GeneralBase> startVertex = edge.getStart();
                Vertex<GeneralBase> endVertex = edge.getEnd();
                if(startVertex != null && endVertex != null) {
                    GeneralBase start = startVertex.getContent();
                    GeneralBase end = endVertex.getContent();
                    g2d.setColor(Color.black);
                    g2d.drawLine(start.getX(), start.getY(), end.getX(), end.getY());
                    if(edge.getWeight().getFront() != null) {
                        int x = (start.getX() + (end.getX()- start.getX())/2) - Constants.UNIT_IMG_HEIGHT/2;
                        int y = (start.getY() + (end.getY() - start.getY())/2)- Constants.UNIT_IMG_WIDTH/2;
                        edge.getWeight().getFront().draw(g2d, x, y);
                    }
                }
            }
        }
    }

    @Override
    public void update(double dt) {
        List<Edge<GeneralBase,Lane>> list = map.getEdges();
        for (list.toFirst();list.hasAccess();list.next()){
            Edge<GeneralBase,Lane> edge = list.getContent();
            if(edge != null) {
                Lane lane = edge.getWeight();
                lane.update(dt);
                Unit unit = lane.getAttackableUnit();
                if(unit != null){
                    edge.getEnd().getContent().getStats().receiveDamage(unit.getStats().getAttack());
                }
            }
        }
    }

    @Override
    public void provideCanvas(ICanvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public Shape getBounds() {
        return rectangle;
    }
}