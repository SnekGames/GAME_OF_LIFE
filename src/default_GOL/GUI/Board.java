package default_GOL.GUI;

import default_GOL.GOL.GameOfLife;

import java.awt.*;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {
    private int screen_height;
    private int screen_width;
    private final int DELAY = 250; // [ms]
    private Timer timer;
    private Grid grid;
    private Graphix gx;
    private Map map;
    private GameOfLife gol1;


    public Board(int x, int y) {
        this.screen_width = x;
        this.screen_height = y;

        this.grid = new Grid(60,120);
        this.gx = new Graphix();
        this.map = new Map();
        this.gol1 = new GameOfLife();

        initFrame();
    }

    private void initFrame() {

        addKeyListener(new Board.TAdapter());
        setFocusable(true);
        setBackground(Color.white);
        setDoubleBuffered(true);


        grid = map.generateBoundary(grid);
        grid = gol1.setupGameOfLife(grid);

        // TEST: Killing a tile
        //pop_distribution_GOL.tools.GridArray gridarray = grid.getGridarray();
        //pop_distribution_GOL.GUI.GridBox gbox = new pop_distribution_GOL.GUI.GridBox("NONE",
        //        "DEFAULT", Boolean.FALSE);
        //gbox.setPopulationDead();
        //gridarray.setObject(9,15, gbox);

        // TEST: Check how many neighbors of the tile are alive
        //pop_distribution_GOL.tools.GridArray gridarray = grid.getGridarray();
        //pop_distribution_GOL.GUI.GridBox gridbox = (pop_distribution_GOL.GUI.GridBox) gridarray.getObject(0,0);
        //int cnt = gol1.howManyAliveNeighbors(0,0, gridarray);
        //System.out.println("Alive of: "); System.out.print(cnt);

        // TEST: See which gridbox i am looking at
        //pop_distribution_GOL.tools.GridArray gridarray = grid.getGridarray();
        //pop_distribution_GOL.GUI.GridBox gbox = new pop_distribution_GOL.GUI.GridBox("NONE",
        //        "DEFAULT", Boolean.FALSE);
        //gbox.setPopulationColor(Color.yellow);
        //gridarray.setObject(8,16, gbox);

        // TEST: Check if a tile is alive
        //pop_distribution_GOL.tools.GridArray gridarray = grid.getGridarray();
        //pop_distribution_GOL.GUI.GridBox gridbox = (pop_distribution_GOL.GUI.GridBox) gridarray.getObject(8,15);
        //System.out.println("Is alive? "); System.out.print(gridbox.isPopulationAlive());


        timer = new Timer( DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //drawFrame(g);
        gx.drawTerrain(grid,g,screen_height,screen_width);

        Toolkit.getDefaultToolkit().sync();
    }

    private void drawFrame(Graphics g) {

        /** Draw physical objects in all handlers in HandlerTracker,
         * with the graphics g, on this board.
         */

        //Graphics2D g2d = (Graphics2D) g;
        //colonist_handler.drawColonists(g, this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
         // Timer interrupt, update and redraw
         // everything!

        // TEST: Check if a tile is alive
        //pop_distribution_GOL.tools.GridArray gridarray1 = grid.getGridarray();
        //pop_distribution_GOL.GUI.GridBox gridbox1 = (pop_distribution_GOL.GUI.GridBox) gridarray1.getObject(8,16);
        //System.out.println("\nIs alive? "); System.out.print(gridbox1.isPopulationAlive());

        // TEST: Check how many neighbors of the tile are alive
        //pop_distribution_GOL.tools.GridArray gridarray = grid.getGridarray();
        //pop_distribution_GOL.GUI.GridBox gridbox = (pop_distribution_GOL.GUI.GridBox) gridarray.getObject(8,16);
        //int cnt = gol1.howManyAliveNeighbors(8,16, gridarray);
        //System.out.println("\nAlive of: "); System.out.print(cnt);

        gol1.advanceMethod(this.grid);
        grid.update();

        // TEST: Check if a tile is alive
        //pop_distribution_GOL.tools.GridArray gridarray2 = grid.getGridarray();
        //pop_distribution_GOL.GUI.GridBox gridbox2 = (pop_distribution_GOL.GUI.GridBox) gridarray2.getObject(8,16);
        //System.out.println("\nIs alive? "); System.out.print(gridbox2.isPopulationAlive());

        repaint();
    }


    private class TAdapter extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e) {
            //events.keyReleased(e);
            //colonist.keyReleased(e);
            //events.checkInteractionKeyReleased(ht,e);

            int key = e.getKeyCode();
            if( key == KeyEvent.VK_SPACE ){
                gx.switchFocus();
            }

        }

        @Override
        public void keyPressed(KeyEvent e) {
            //events.keyPressed(e);
            //colonist.keyPressed(e);
            //events.checkInteractionKeyPressed(ht,e);
        }
    }

}