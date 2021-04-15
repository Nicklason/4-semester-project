/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * @author steff
 */
public class StartMenu implements Screen{
    
    private GameCore game;
    private Texture playbtn;
    private Texture exitbtn;
    private Texture headline;
    private Texture background;



    public StartMenu(GameCore GameCore) {
        this.game = GameCore;
        this.playbtn = new Texture("../dk.sdu.se4.core/src/main/resources/img/Playbtn.png");
        this.exitbtn = new Texture("../dk.sdu.se4.core/src/main/resources/img/Exitbtn.png");
        this.headline = new Texture("../dk.sdu.se4.core/src/main/resources/img/HeadLine.png");
        this.background = new Texture("../dk.sdu.se4.core/src/main/resources/img/Background.png");
    }
    
            

    
    public void show() {
    }

    @Override
    public void render(float f) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        this.game.batch.begin();
        this.game.batch.draw(this.background,(float)(this.game.width/4.2),(float) (this.game.height/12),400,500);
        this.game.batch.draw(this.headline,(float)(this.game.width/3.8), (float) (this.game.height/1.333), 350,50);
        this.game.batch.draw(this.playbtn,(float)(this.game.width/2.66),(float) (this.game.height/2));
        this.game.batch.draw(this.exitbtn,(float)(this.game.width/2.66),(float) (this.game.height/3));

        if(Gdx.input.getX()< (this.game.width/2.66)+this.exitbtn.getWidth()&& Gdx.input.getX()>(this.game.width/2.66) &&
                Gdx.input.getY()<(this.game.height/1.7)+this.exitbtn.getHeight() && Gdx.input.getY()>(this.game.height/1.7)){
            this.game.batch.draw(this.exitbtn,(float)(this.game.width/2.66),(float) (this.game.height/3));
            if(Gdx.input.isTouched()){
                Gdx.app.exit();
            }
        }
        if(Gdx.input.getX()< (this.game.width/2.66)+this.playbtn.getWidth()&& Gdx.input.getX()>(this.game.width/2.66) &&
                Gdx.input.getY()<(this.game.height/2.7)+this.playbtn.getHeight() && Gdx.input.getY()>(this.game.height/2.7)){
            this.game.batch.draw(this.playbtn,(float)(this.game.width/2.66),(float) (this.game.height/2));
            if(Gdx.input.isTouched()){
                this.dispose();
                game.setScreen(new GameScreen(this.game));
            }
        }
        this.game.batch.end();
        
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
