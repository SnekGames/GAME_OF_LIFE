package default_GOL.GUI;

import java.awt.*;

public class Terrain {
    String terrainTypeName;

    Color terrainTypeColor;

    Terrain(String terrainTypeName){
        this.terrainTypeName = terrainTypeName;
        if (terrainTypeName == "NONE"){
            terrainTypeColor = Color.gray;
        }
        else if(terrainTypeName == "WATER"){
            terrainTypeColor = Color.blue;
        }
        else if(terrainTypeName == "GRASS"){
            terrainTypeColor = Color.green;
        }
        else if(terrainTypeName == "BOUNDARY"){
            terrainTypeColor = Color.black;
        }
        else {
            System.out.println("ERROR WRONG TERRAIN TYPE DEFINED");
        }
    }

    public void update(){

    }

    public String getTerrainTypeName() {
        return terrainTypeName;
    }

    public Color getTerrainTypeColor() {
        return terrainTypeColor;
    }

    public void setTerrainTypeName(String terrainTypeName) {
        this.terrainTypeName = terrainTypeName;
    }

}