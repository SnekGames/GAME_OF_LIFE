/**
 * Created by Viktor on 2017-04-28.
 */


import java.awt.*;

public class Main {

/**
 * Created by Viktor on 2016-11-18.
 */
    static public void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                default_GOL.GUI.Application gol = new default_GOL.GUI.Application();
                //pop_distribution_GOL.GUI.Application gol = new pop_distribution_GOL.GUI.Application();

                gol.setVisible(true);
            }
        });
    }
}
