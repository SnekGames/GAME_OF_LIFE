package default_GOL.GUI; /**
 * Created by Viktor on 2016-11-18.
 */


import java.awt.*;
import javax.swing.JFrame;

public class Application extends JFrame {
    int screen_height;
    int screen_width;

    public Application() {
        initUI();
    }

    private void initUI() {
        // Send size of screen to the pop_distribution_GOL.GUI.Board
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        //setUndecorated(true); //MAKES IT BORDERLESS
        screen_width = (int) screenSize.getWidth();
        screen_height = (int) screenSize.getHeight();

        setSize( (int)( screen_width*1 ), (int) ( screen_height*1 ) );
        add(new Board( (int)( screen_width*1 ), (int) ( screen_height*1 ) )); //UGLY FIX FOR PART OF  THE WINDOW ENDING UP OUTSIDE SCREEN
        setResizable(false);
        Toolkit.getDefaultToolkit().getScreenSize();
        //pack();

        setTitle("GOL");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
