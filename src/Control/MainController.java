package Control;

import View.MainFrame;

/**
 * Created by Oussama on 02.06.2017.
 */
public class MainController {
    private MainFrame frame;
    private ScreenController screenController;

    public MainController(MainFrame frame){
        this.frame = frame;
        screenController = new ScreenController(this);
    }

    public MainFrame getFrame(){
        return frame;
    }
}
