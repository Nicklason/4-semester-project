/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.core;

import com.badlogic.gdx.Game;
import dk.sdu.se4.core.sceens.MenuSceen;
/**
 *
 * @author steff
 */
public class GameStarter extends Game{
    

    @Override
    public void create() {
        setScreen(new MenuSceen());
        
        
    }

    @Override
    public void resize(int i, int i1) {
        super.resize(i1, i1);
    }

    @Override
    public void render() {
       super.render();
    }

    @Override
    public void pause() {
       super.pause();
    }

    @Override
    public void resume() {
      super.resume();
    }

    @Override
    public void dispose() {
       super.dispose();
        
    }
    
  
    
    
    
    

}
