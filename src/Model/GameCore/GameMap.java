package Model.GameCore;

import Model.DataStructure.Extended.Edge;
import Model.DataStructure.Extended.Graph;
import Model.DataStructure.Extended.Utils;
import Model.DataStructure.Extended.Vertex;
import Model.DataStructure.List;
import Model.GameCore.GameObject.Base.GeneralBase;
import Model.Constants;
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

    private Graph map;
    private ICanvas canvas;

    private List<List<GeneralBase>> alllign;

    public GameMap(double width, double height, double x, double y){
        this.width = (int) width;
        this.height = (int) height;
        this.x = (int) x;
        this.y = (int) y;

        map = new Graph<GeneralBase,Lane>();

        alllign = new List<>();

        rectangle = new Rectangle(this.x,this.y,this.width,this.height);
    }

    public void addBaseRow(List<GeneralBase> bases){
        for (bases.toFirst();bases.hasAccess();bases.next()){
            map.addVertex(new Vertex<>(bases.getContent()));
        }
        alllign.append(bases);
    }

    public void addLane(GeneralBase home, GeneralBase target){
        map.addEdge(new Edge(map.getVertex(home),map.getVertex(target),new Lane()));

    }

    @Override
    public void draw() {
        Graphics2D g2d = canvas.getPencil();
        g2d.draw(rectangle);
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

    @Override
    public void update(double dt) {

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