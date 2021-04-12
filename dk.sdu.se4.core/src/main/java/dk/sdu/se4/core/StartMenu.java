/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * @author steff
 */
public class StartMenu implements Screen{
    
    private GameCore GameCore;
    private SpriteBatch batch;

    public StartMenu(GameCore GameCore) {
        this.GameCore = GameCore;
    }
    
            

    
    public void show() {
        System.out.println("Starte Show");
        this.batch=new SpriteBatch();
    }

    @Override
    public void render(float f) {
        Gdx.gl.glClearColor(0, 1, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
         this.batch.begin();
          this.batch.end();
        
    }

    @Override
    public void resize(int i, int i1) {
    
    }

    @Override
    public void pause() {
        
    }

    @Override
    public void resume() {
       
    }

    @Override
    public void hide() {
       
    }

    @Override
    public void dispose() {
        
    }
    
}
