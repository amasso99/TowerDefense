package Model.UI.Screen;

import Model.UI.Label;
import View.Panel.DrawingPanel;
import javafx.scene.text.Font;

/**
 * Created by Oussama on 02.06.2017.
 */
public class MainScreen extends DrawingPanel {

    public MainScreen(){
        Font f = new Font(22);
        Label label = new Label(500,500,"ES GEHT", null );
        addObject(label);
    }

}
