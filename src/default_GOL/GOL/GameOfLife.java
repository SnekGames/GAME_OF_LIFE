package default_GOL.GOL;


import default_GOL.GUI.Grid;
import default_GOL.GUI.GridBox;
import default_GOL.tools.GridArray;

/**
 * Created by Viktor on 2017-05-01.
 */
public class GameOfLife  {
    // Extend the method to be used.. the main function used to update the
    // gridboxes is called as "advanceMethod" from pop_distribution_GOL.GUI.Board

    int grid_spawnX;
    int grid_spawnY;

    public GameOfLife(){
    }

    public Grid setupGameOfLife(Grid grid){

        // Test spawning some stuff
        grid = spawnGameOfLife(28,45,
                "POP1", grid);
        grid = spawnGameOfLife(29,46,
                "POP1", grid);
        grid = spawnGameOfLife(28,47,
                "POP1", grid);
        grid = spawnGameOfLife(29,47,
                "POP1", grid);
        grid = spawnGameOfLife(29,46,
                "POP1", grid);

        return grid;
    }


    public Grid spawnGameOfLife(int grid_spawn_row, int grid_spawn_col, String populationName, Grid grid){
        this.grid_spawnX = grid_spawn_col;
        this.grid_spawnY = grid_spawn_row;

        GridArray gridarray = grid.getGridarray();
        int M_rows = gridarray.getM_rows();
        int N_columns = gridarray.getN_columns();

        // If there is a terrain there since before, this overrides that terrain with no
        // good  way of knowing what the original terrrain was

        if( (grid_spawnX < N_columns) && (grid_spawnY < M_rows) ) {

            gridarray.setObject(grid_spawnY, grid_spawnX, new GridBox( "NONE",
                    populationName, Boolean.TRUE));
        }
        else{
            System.out.println("ERROR: TRIED TO SPAWN A GAME OF LIFE OUTSIDE OF GRID BOUNDARY");
        }


        grid.setGridarray(gridarray); // Currently gridarray is passed as reference, so this is unnecessary
        return grid;
    }

    public Grid advanceMethod(Grid grid ) {

        grid = Method1.advanceMethod1(grid);
        //grid = pop_distribution_GOL.GOL.Method2.advanceMethod2(grid);
        return grid;
    }



}
