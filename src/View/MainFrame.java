package View;


import View.Panel.DrawingPanel;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static View.Panel.DrawingPanel.screenHeight;
import static View.Panel.DrawingPanel.screenWidth;

public class MainFrame extends JFrame implements MouseListener {

    private JLayeredPane contentPane;

    private DrawingPanel background;
    private DrawingPanel content;
    private DrawingPanel foreground;

    public MainFrame(String name) {
        setLocation(0,0);
        setSize(screenWidth, screenHeight);


        contentPane = new JLayeredPane();
        contentPane.setSize(getSize());
        contentPane.setLayout(null);

        setContentPane(contentPane);

        setTitle(name);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setVisible(true);
    }

    public void setContentPanel(DrawingPanel p) {
        if (p == null)
            throw new NullPointerException();
        p.setSize(getSize());
        if (content != null) {
            contentPane.remove(content);
            removeKeyListener(content);
        }
        content = p;
        contentPane.add(p);
        contentPane.setLayer(p, 1);
        addKeyListener(p);
        repaint();
        revalidate();
    }

    public void setBackgroundPanel(DrawingPanel p) {
        p.setSize(getSize());
        if (background != null) {
            contentPane.remove(background);
        }
        background = p;
        if (p != null) {
            contentPane.add(p);
            contentPane.setLayer(p, 0);
        }
        repaint();
        revalidate();
    }

    public void setForegroundPanel(DrawingPanel p) {
        p.setSize(getSize());
        if (foreground != null) {
            contentPane.remove(foreground);
            removeKeyListener(foreground);
            foreground.removeMouseListener(this);
        }
        foreground = p;
        if (p != null) {
            contentPane.add(p);
            contentPane.setLayer(p, 2);
            p.addMouseListener(this);
        }
        addKeyListener(p);
        repaint();
        revalidate();
    }

    //Since we have a foreground panel, its impossible for the contentpanel to get click events. Thus we need to delegate them form the foreground panel
    @Override
    public void mouseClicked(MouseEvent e) {
        content.mouseClicked(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        content.mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        content.mouseReleased(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        content.mouseEntered(e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        content.mouseExited(e);
    }
}
