package View.Panel;

import View.Abstraction.ICanvas;
import View.Abstraction.IDrawableObject;
import View.Abstraction.IInteractableObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class DrawingPanel extends JComponent implements ActionListener, KeyListener, MouseListener, ICanvas {

    public static final int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
    public static final int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

    private boolean graphicsLock;

    protected long lastLoop;
    protected long elapsedTime;

    protected ArrayList<IDrawableObject> drawableObjects;

    protected Timer timer;

    private Graphics2D graphics;

    public DrawingPanel() {
        super();
        this.drawableObjects = new ArrayList<>();
        this.timer = new Timer(16, this);

        addMouseListener(this);
        setDoubleBuffered(true);

        lastLoop = System.nanoTime();
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        elapsedTime = System.nanoTime() - lastLoop;
        lastLoop = System.nanoTime();
        int dt = (int) ((elapsedTime / 1000000L) + 0.5);
        if (dt == 0) dt = 1;
        graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.translate(getRenderingOffset().getX(), getRenderingOffset().getY());
        graphicsLock = true;
        for (IDrawableObject tempDO : drawableObjects) {
            Rectangle2D bounds = tempDO.getBounds().getBounds();
            //Dont draw if its not on screen.
            if (bounds.getX() + bounds.getWidth() + getRenderingOffset().getX() < 0 || bounds.getY() + bounds.getHeight() + getRenderingOffset().getY() < 0
                    || bounds.getX() + getRenderingOffset().getX() > screenWidth || bounds.getY() + getRenderingOffset().getY() > screenHeight) {
                continue;
            }
            tempDO.draw();
            tempDO.update((double) dt / 1000);
        }
        graphicsLock = false;
    }

    protected Point getRenderingOffset() {
        return new Point(0, 0);
    }

    @Override
    public Graphics2D getPencil() {
        if (!canDraw()) {
            throw new UnsupportedOperationException("Graphics Context currently not available");
        }
        return graphics;
    }

    @Override
    public void addObject(IDrawableObject d) {
        drawableObjects.add(d);
        d.provideCanvas(this);
    }

    @Override
    public void removeObject(IDrawableObject d) {
        drawableObjects.remove(d);
    }

    @Override
    public void scheduleRemoveObject(IDrawableObject object) {
        SwingUtilities.invokeLater(() -> removeObject(object));
    }

    @Override
    public void scheduleAddObject(IDrawableObject object) {
        SwingUtilities.invokeLater(() -> addObject(object));
    }

    @Override
    public boolean canDraw() {
        return graphicsLock;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        drawableObjects.stream()
                .filter(tempDO -> tempDO instanceof IInteractableObject)
                .forEach(tempDO -> ((IInteractableObject) tempDO).keyPressed(e.getKeyCode()));
    }

    public void keyReleased(KeyEvent e) {
        drawableObjects.stream()
                .filter(tempDO -> tempDO instanceof IInteractableObject)
                .forEach(tempDO -> ((IInteractableObject) tempDO).keyReleased(e.getKeyCode()));

    }

    public void mouseClicked(MouseEvent e) {
        drawableObjects.stream()
                .filter(tempDO -> tempDO instanceof IInteractableObject)
                .filter(tempDO -> tempDO.getBounds().contains(e.getPoint()))
                .forEach(tempDO -> ((IInteractableObject) tempDO).mouseClicked(e));
    }

    public void mousePressed(MouseEvent e) {
        drawableObjects.stream()
                .filter(tempDO -> tempDO instanceof IInteractableObject)
                .filter(tempDO -> tempDO.getBounds().contains(e.getPoint()))
                .forEach(tempDO -> ((IInteractableObject) tempDO).mousePressed(e));
    }

    public void mouseReleased(MouseEvent e) {
        drawableObjects.stream()
                .filter(tempDO -> tempDO instanceof IInteractableObject)
                .filter(tempDO -> tempDO.getBounds().contains(e.getPoint()))
                .forEach(tempDO -> ((IInteractableObject) tempDO).mouseReleased(e));
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

}
