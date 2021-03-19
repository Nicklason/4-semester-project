/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.common.data;

/**
 *
 * @author steff
 */
public class GameData {
    private float delta;
    private int displayWidth;
    private int displayHeight;
    private GameData gameDataInstance = null;
    
    private GameData(){
        
    }
    public GameData getInstance(){
        if(this.gameDataInstance==null){
            this.gameDataInstance= new GameData();
        }
        return this.gameDataInstance;
    }

    public float getDelta() {
        return delta;
    }

    public void setDelta(float delta) {
        this.delta = delta;
    }

    public int getDisplayWidth() {
        return displayWidth;
    }

    public void setDisplayWidth(int displayWidth) {
        this.displayWidth = displayWidth;
    }

    public int getDisplayHeight() {
        return displayHeight;
    }

    public void setDisplayHeight(int displayHeight) {
        this.displayHeight = displayHeight;
    }
    
    
    
}
