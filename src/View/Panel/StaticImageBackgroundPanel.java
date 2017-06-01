package View.Panel;

import java.awt.*;

/**
 * Created by Max on 17.12.2016.
 */
public class StaticImageBackgroundPanel extends StaticDrawingPanel {

    protected Image image;

    public StaticImageBackgroundPanel(Image image) {
        this.image = image;
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(image, screenWidth / 2 - image.getWidth(this) / 2, screenHeight / 2 - image.getHeight(this) / 2, this);
    }
}
