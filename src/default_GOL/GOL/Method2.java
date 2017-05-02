package default_GOL.GOL;


import default_GOL.GUI.Grid;
import default_GOL.GUI.GridBox;
import default_GOL.tools.GridArray;

/**
 * Created by Viktor on 2017-05-02.
 */
public class Method2 {

    public static Grid advanceMethod2 (Grid grid){
        // First revive dead tiles that should be revived, then
        // kill tiles that should die, update grid and then
        // send it back
        grid = reviveTiles(grid);
        grid = killTiles(grid);
        return grid;
    }

    public static Grid killTiles(Grid grid ){

        GridArray gridarray = grid.getGridarray();
        int M_rows = gridarray.getM_rows();
        int N_columns = gridarray.getN_columns();

        for(int m = 0; m<M_rows; m++){
            for(int n=0; n<N_columns; n++){

                GridBox gridBox = (GridBox) gridarray.getObject(m,n);
                Boolean subject_alive = gridBox.isPopulationAlive();

                if( (subject_alive == Boolean.TRUE) &&
                        (gridBox.getTerrainTypeName() != "BOUNDARY") ){

                    //System.out.println("\n\nalive");
                    //System.out.print(m); System.out.print(n);

                    int cnt = howManyAliveNeighbors(m,n, gridarray);

                    //if ( (cnt<=1) || (cnt>=4) ){
                    if( cnt >= 4){
                        gridBox.setPopulationDead();
                    }
                    else{
                        gridBox.setPopulationAlive();
                    }
                }

                gridarray.setObject(m,n,gridBox);

            }
        }

        grid.setGridarray(gridarray); // Currently gridarray is passed as reference, so this is unnecessary
        return grid;
    }

    public static Grid reviveTiles(Grid grid ){

        GridArray gridarray = grid.getGridarray();
        int M_rows = gridarray.getM_rows();
        int N_columns = gridarray.getN_columns();

        for(int m = 0; m<M_rows; m++){
            for(int n=0; n<N_columns; n++){

                GridBox gridBox = (GridBox) gridarray.getObject(m,n);
                Boolean subject_alive = gridBox.isPopulationAlive();

                if( (subject_alive == Boolean.FALSE) &&
                        (gridBox.getTerrainTypeName() != "BOUNDARY") ){

                    int cnt = howManyAliveNeighbors(m,n, gridarray);

                    if ( (cnt ==1) || (cnt == 2) ){
                    //if ( cnt == 2 ){
                        gridBox.setPopulationAlive();
                    }
                    else{
                        gridBox.setPopulationDead();
                    }
                }

                gridarray.setObject(m,n,gridBox);

            }
        }

        grid.setGridarray(gridarray); // Currently gridarray is passed as reference, so this is unnecessary
        return grid;
    }

    public static int howManyAliveNeighbors( int subject_y, int subject_x, GridArray g ){
        int cnt = 0;
        GridBox subject = (GridBox) g.getObject(subject_y,subject_x);

        if (subject.getTerrainTypeName() != "BOUNDARY") {
            // Make sure to not step off the grid

            GridBox neighbor_up = (GridBox) g.getObject(subject_y - 1, subject_x);
            GridBox neighbor_down = (GridBox) g.getObject(subject_y + 1, subject_x);
            GridBox neighbor_left = (GridBox) g.getObject(subject_y, subject_x - 1);
            GridBox neighbor_right = (GridBox) g.getObject(subject_y, subject_x + 1);
            GridBox neighbor_upright = (GridBox) g.getObject(subject_y - 1, subject_x + 1);
            GridBox neighbor_upleft = (GridBox) g.getObject(subject_y - 1, subject_x - 1);
            GridBox neighbor_downright = (GridBox) g.getObject(subject_y + 1, subject_x + 1);
            GridBox neighbor_downleft = (GridBox) g.getObject(subject_y + 1, subject_x - 1);

            if ((neighbor_up.isPopulationAlive() == Boolean.TRUE) &&
                    (neighbor_up.getTerrainTypeName() != "BOUNDARY")) {
                cnt++;
            }
            if ((neighbor_down.isPopulationAlive() == Boolean.TRUE) &&
                    (neighbor_down.getTerrainTypeName() != "BOUNDARY")) {
                cnt++;
            }
            if ((neighbor_left.isPopulationAlive() == Boolean.TRUE) &&
                    (neighbor_left.getTerrainTypeName() != "BOUNDARY")) {
                cnt++;
            }
            if ((neighbor_right.isPopulationAlive() == Boolean.TRUE) &&
                    (neighbor_right.getTerrainTypeName() != "BOUNDARY")) {
                cnt++;
            }
            if ((neighbor_upright.isPopulationAlive() == Boolean.TRUE) &&
                    (neighbor_upright.getTerrainTypeName() != "BOUNDARY")) {
                cnt++;
            }
            if ((neighbor_upleft.isPopulationAlive() == Boolean.TRUE) &&
                    (neighbor_upleft.getTerrainTypeName() != "BOUNDARY")) {
                cnt++;
            }
            if ((neighbor_downright.isPopulationAlive() == Boolean.TRUE) &&
                    (neighbor_downright.getTerrainTypeName() != "BOUNDARY")) {
                cnt++;
            }
            if ((neighbor_downleft.isPopulationAlive() == Boolean.TRUE) &&
                    (neighbor_downleft.getTerrainTypeName() != "BOUNDARY")) {
                cnt++;
            }
        }

        return cnt;
    }
}
