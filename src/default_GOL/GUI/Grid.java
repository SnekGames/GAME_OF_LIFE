package default_GOL.GUI; /**
 * Created by Viktor on 2017-04-28.
 */

import default_GOL.tools.GridArray;

public class Grid {
    //String defaultTerrainType = "NONE";
    //String defaultPopulation = "DEFAULT";
    //Boolean defaultAlive = Boolean.FALSE;

    GridArray gridarray;

    public GridArray getGridarray() {
        return gridarray;
    }

    public void setGridarray(GridArray gridarray) {
        this.gridarray = gridarray;
    }

    Grid(int M_rows, int N_columns){
        // Fill the grid with no terrain - dead - gridboxes.

        this.gridarray = new GridArray();
        for(int m = 0; m<M_rows; m++){
            for(int n=0; n<N_columns; n++){
                gridarray.setObject(m,n, new GridBox("NONE",
                        "DEFAULT", Boolean.FALSE));
            }
        }

        //this.gridarray.setObject(M_rows,N_columns, pop_distribution_GOL.GUI.GridBox);
    }

    public void update(){

        int M_rows = gridarray.getM_rows();
        int N_columns = gridarray.getN_columns();

        for(int m = 0; m<M_rows; m++){
            for(int n=0; n<N_columns; n++){
                GridBox g = (GridBox) gridarray.getObject(m,n);
                g.update();
                gridarray.setObject(m,n,g);
            }
        }
    }



}
