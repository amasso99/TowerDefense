package Model.UI;

import View.Abstraction.ICanvas;
import View.Abstraction.IDrawableObject;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by janpa on 29.06.2017.
 */
public class Popup implements IDrawableObject {

    private int x;
    private int y;

    private String text;
    private Font font;

    private int r;
    private int g;
    private int b;
    private int a;

    private Color color;

    private ICanvas canvas;

    public Popup(int x, int y, String text, Font font, int r, int g, int b){
        this.x = x;
        this.y = y;
        this.text = text;
        this.font = font;
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = 255;
        //color = new Color(0,0,0);
    }
    @Override
    public void draw() {
        Graphics2D g2d = canvas.getPencil();
        g2d.setFont(font);
        g2d.setColor(new Color(r,g,b,a));
        g2d.drawString(text,x,y);
        if(a > 0){
            a--;
        }else if(a == 0){
            //removeObject
        }
    }

    @Override
    public void update(double dt) {
        //System.out.println(a);
    }

    @Override
    public void provideCanvas(ICanvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public Shape getBounds() {
        return new Rectangle2D.Double.Double.Double.Double(0, 0, 0, 0);
    }

    public int getA(){
        return a;
    }
}
