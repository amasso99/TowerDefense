package Model.UI;


import View.Abstraction.ICanvas;
import View.Abstraction.IDrawableObject;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Label implements IDrawableObject {

    private int x;
    private int y;

    private String text;

    private ICanvas canvas;

    private Font font;

    private Color foregroundColor;

    public Label(int x, int y, String text, Font font) {
        this.text = text;
        this.x = x;
        this.y = y;
        this.font = font;
        this.foregroundColor = Color.BLACK;
    }

    @Override
    public void draw() {
        Graphics2D g2d = canvas.getPencil();
        //g2d.setFont(font);
        g2d.setColor(foregroundColor);

        FontMetrics metrics = g2d.getFontMetrics();

        g2d.drawString(text, x - metrics.stringWidth(text) / 2, y);
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
        return new Rectangle2D.Double.Double.Double.Double(0, 0, 0, 0);
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public void setText(String text){
        this.text = text;
    }

    public void setForegroundColor(Color foregroundColor) {
        this.foregroundColor = foregroundColor;
    }
}
