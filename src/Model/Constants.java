package Model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;

/**
 * Created by Oussama on 02.06.2017.
 */
public class Constants {
    public static final int TOWER_IMG_WIDTH = 100;
    public static final int TOWER_IMG_HEIGHT = 100;

    public static final int UNIT_IMG_WIDTH = 50;
    public static final int UNIT_IMG_HEIGHT = 50;

    public static final int MOVING_TIME = 5;


    public static BufferedImage readImageSave(Path path){
        System.out.println("Reading: "+path);
        try {
            return ImageIO.read(path.toFile());
        } catch (IOException e) {
        }
        //The Compiler is too stupid to notice that we either return something or exit the program, so we need return null here
        return null;
    }

}
