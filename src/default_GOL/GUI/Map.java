package default_GOL.GUI;

import default_GOL.tools.GridArray;

/**
 * Created by Viktor on 2017-04-30.
 */
public class Map {

    Grid generateBoundary(Grid grid){

        GridArray gridarray = grid.getGridarray();
        int M_rows = gridarray.getM_rows();
        int N_columns = gridarray.getN_columns();

        for(int x=0; x<N_columns; x++){
            int y = 0;
            gridarray.setObject(y,x,new GridBox("BOUNDARY",
                    "NONE", Boolean.FALSE));
        }
        for(int x=0; x<N_columns; x++){
            int y = M_rows-1;
            gridarray.setObject(y,x,new GridBox("BOUNDARY",
                    "NONE", Boolean.FALSE));
        }
        for(int y=0; y<M_rows; y++){
            int x = 0;
            gridarray.setObject(y,x,new GridBox("BOUNDARY",
                    "NONE", Boolean.FALSE));
        }
        for(int y=0; y<M_rows; y++){
            int x = N_columns-1;
            gridarray.setObject(y,x,new GridBox("BOUNDARY",
                    "NONE", Boolean.FALSE));
        }

        grid.setGridarray(gridarray); // Currently gridarray is passed as reference, so this is unnecessary
        return grid;
    }
}
