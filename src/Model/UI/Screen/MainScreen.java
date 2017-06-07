package Model.UI.Screen;

import Model.UI.ActionEvent;
import Model.UI.Button;
import Model.UI.Label;
import View.Panel.DrawingPanel;
import javafx.scene.text.Font;

/**
 * Created by Oussama on 02.06.2017.
 */
public class MainScreen extends DrawingPanel implements ActionEvent {

    public MainScreen(){
        Font f = new Font(22);
        Label label = new Label(500,500,"ES GEHT", null );
        addObject(label);

        Button button = new Button("Exit",100,100,100,100,"exit");
        button.setActionListener(this);

        addObject(button);
    }

    @Override
    public void doAction(String id) {
        if(id.equalsIgnoreCase("exit")){
            System.exit(0);
        }
    }
}
