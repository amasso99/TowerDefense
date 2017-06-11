package Model.UI;

import View.Abstraction.ICanvas;
import View.Abstraction.IInteractableObject;

import java.awt.*;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseEvent;

/**
 * Created by 204g07 on 02.06.2017.
 */
public class Button implements IInteractableObject {

    private String text,id;
    private Image img;
    private ActionEvent event;
    private int x,y,width,height;
    private Font font;
    private Shape shape;

    private ICanvas canvas;


    public Button(String text, int x, int y,int width, int height, String id, Font font){
        this.text = text;
        this.id = id;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.font = font;
        shape = new Rectangle(x,y,width,height);
    }

    public Button(String text, double x, double y,double width, double height, String id, Font font){
        this(text,(int)x,(int)y,(int)width,(int)height,id,font);
    }


    public Button(Image img, int x, int y, String id){
        this.img = img;
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public void setActionListener(ActionEvent listener){
        this.event = listener;
    }

    @Override
    public void draw() {
        Graphics2D g2d = canvas.getPencil();

        if(img == null){
            FontMetrics metrics = g2d.getFontMetrics(font);
            int fontHeight = metrics.getHeight();
            int fontWidth = metrics.stringWidth(text);
            g2d.setColor(Color.BLACK);
            g2d.drawString(text, (int) (x + width/2 - fontWidth*0.5),y + height/2);
            g2d.setColor(new Color(50, 50, 50));
            g2d.drawRect(x, y, width, height);
        }else{

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
        return shape;
    }


    @Override
    public void keyPressed(int key) {

    }

    @Override
    public void keyReleased(int key) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        PointerInfo info = MouseInfo.getPointerInfo();
        if(info!= null){
            if(shape.contains(info.getLocation())){
                if(event != null){
                    event.doAction(id);
                }
            }
        }
    }
}
