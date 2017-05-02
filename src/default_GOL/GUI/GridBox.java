package default_GOL.GUI;

import java.awt.*;

/**
 * Created by Viktor on 2017-04-28.
 */
public class GridBox {

    Terrain terrain;
    Population population;


    public GridBox(String terrainTypeName, String populationName, Boolean alive) {
        this.terrain = new Terrain(terrainTypeName);
        this.population = new Population(populationName, alive);

    }

    public void update(){
        population.update();
        terrain.update();
    }

    public Color getTerrainTypeColor() {
        return terrain.getTerrainTypeColor();
    }

    public String getTerrainTypeName(){
        return terrain.getTerrainTypeName();
    }

    public Color getPopulationColor() {
        return population.getPopulationColor();
    }

    public void setPopulationColor(Color populationColor) {
        population.setPopulationColor(populationColor);
    }

    public String getPopulationName(){
        return population.getPopulationName();
    }

    public Boolean isPopulationAlive(){
        return population.getAliveStatus();
    }

    public void setPopulationAlive(){
        population.flagRevive();
    }

    public void setPopulationDead(){
        population.flagDeath();
    }


}
