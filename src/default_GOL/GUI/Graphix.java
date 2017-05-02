package default_GOL.GUI;

import default_GOL.tools.GridArray;

import java.awt.*;

/**
 * Created by Viktor on 2017-02-22.
 */
public class Graphix {

    // These toggle view modes
    Boolean focusTerrain;
    Boolean focusPopulation;

    public Graphix() {
        // Default: Focus the view on the population
        focusTerrain = Boolean.FALSE;
        focusPopulation = Boolean.TRUE;

    }

    public void drawSquareGrid(Grid grid){

    }

    public void drawTerrain(Grid grid, Graphics g, int screen_height, int screen_width){

        GridArray gridarray = grid.getGridarray();

        int M_rows = gridarray.getM_rows();
        int N_columns = gridarray.getN_columns();
        int tile_pixels_x = screen_width/N_columns;
        int tile_pixels_y = screen_height/M_rows;

        for(int m = 0; m<M_rows; m++){
            for(int n=0; n<N_columns; n++){
                GridBox gridbox = (GridBox) gridarray.getObject(m,n);
                String terrainTypeName = gridbox.getTerrainTypeName();
                // +m and +n adds a white line between the tiles,
                // +tile_pixels_x and +tile_pixels_y adds som space around the
                // edge of the tiles
                drawTile(terrainTypeName, gridbox, g,
                        n*tile_pixels_x+n, m*tile_pixels_y+m,
                        tile_pixels_x-1, tile_pixels_y-1);
            }
        }

    }


    public void drawPopulation(Grid grid){

    }

    public void switchFocus(){

        if ( (focusPopulation == Boolean.TRUE) &&
                (focusTerrain == Boolean.FALSE) ){
            focusPopulation = Boolean.FALSE;
            focusTerrain = Boolean.TRUE;
        }
        else if ( (focusPopulation == Boolean.FALSE) &&
                (focusTerrain == Boolean.TRUE) ){
            focusPopulation = Boolean.TRUE;
            focusTerrain = Boolean.FALSE;
        }

    }

    private void drawTile(String terrainType, GridBox gridbox, Graphics g, int posx, int posy, int tile_width, int tile_height){
        Color tileColor;

        if( (focusPopulation == Boolean.TRUE) &&
                (focusTerrain == Boolean.FALSE) &&
                (gridbox.getTerrainTypeName() != "BOUNDARY")) { //THIS WILL CHANGE TO A KEYBIND LATER
            tileColor = gridbox.getPopulationColor();
        }
        else if( ((focusPopulation == Boolean.FALSE) &&
                (focusTerrain == Boolean.TRUE)) ||
                (gridbox.getTerrainTypeName() == "BOUNDARY")) {
            // Always draw boundary
            tileColor = gridbox.getTerrainTypeColor();
        }
        else{
            tileColor = Color.red;
        }

        g.setColor( tileColor );
        g.fillRect(posx, posy, tile_width, tile_height);
    }

}