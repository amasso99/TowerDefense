import Control.MainController;
import View.MainFrame;


public class Core {
    public static void main(String[] args) {
        MainFrame frame = new MainFrame("Tower Defense");
        MainController controller = new MainController(frame);
    }
}
