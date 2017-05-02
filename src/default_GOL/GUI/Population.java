package default_GOL.GUI;

import java.awt.*;

/**
 * Created by Viktor on 2017-05-01.
 */
public class Population {
    String populationName;
    int populationCount;
    Color populationColor;
    Boolean alive;
    Boolean deathFlag;
    Boolean reviveFlag;
    Color colorDead;
    Color colorAlive;

    Population(String populationName, Boolean alive){
        this.populationName = populationName;
        this.alive = alive;
        this.deathFlag = Boolean.FALSE;
        this.reviveFlag = Boolean.FALSE;
        this.colorAlive = new Color(200,162,200); // #SANGO
        this.colorDead = Color.DARK_GRAY;


        if ( alive == Boolean.TRUE ){
            populationColor = colorAlive;
        }
        else if( alive == Boolean.FALSE ){
            populationColor = colorDead;
        }
        else {
            System.out.println("ERROR UNSURE IF POPULATION IS ALIVE OR DEAD");
        }
    }

    public void update(){

        if( deathFlag == Boolean.TRUE){
            deathFlag = Boolean.FALSE;
            setDead();
        }
        if( reviveFlag == Boolean.TRUE){
            reviveFlag = Boolean.FALSE;
            setAlive();
        }
    }

    public String getPopulationName() {
        return populationName;
    }

    public Color getPopulationColor() {
        return populationColor;
    }

    public void setPopulationColor(Color populationColor) {
        this.populationColor = populationColor;
    }

    public void setPopulationName(String populationName) {
        this.populationName = populationName;
    }

    public Boolean getAliveStatus(){
        return this.alive;
    }



    private void setAlive(){
        alive = Boolean.TRUE;
        populationColor = colorAlive;
    }

    private void setDead(){
        alive = Boolean.FALSE;
        populationColor = colorDead;

    }

    public void flagRevive(){
        reviveFlag = Boolean.TRUE;
    }

    public void flagDeath(){
        deathFlag = Boolean.TRUE;
    }

}
