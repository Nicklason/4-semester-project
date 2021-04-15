/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author steff
 */
public class StartMenu implements Screen{
    private final static Logger logger = LoggerFactory.getLogger(GameScreen.class);
    private GameCore game;
    private Texture playbtn;
    private Texture playActivebtn;
    private Texture exitbtn;
    private Texture exitActivebtn;
    private Texture headline;
    private Texture background;
    private Sound startsound;
    private Sound playsound;
    private Sound exitsound;




    public StartMenu(GameCore GameCore) {
        this.game = GameCore;
        this.playbtn = new Texture("../dk.sdu.se4.core/src/main/resources/img/play.png");
        this.playActivebtn = new Texture("../dk.sdu.se4.core/src/main/resources/img/playActive.png");
        this.exitbtn = new Texture("../dk.sdu.se4.core/src/main/resources/img/exit.png");
        this.exitActivebtn = new Texture("../dk.sdu.se4.core/src/main/resources/img/exitActive.png");
        this.headline = new Texture("../dk.sdu.se4.core/src/main/resources/img/HeadLine.png");
        this.background = new Texture("../dk.sdu.se4.core/src/main/resources/img/Background.png");
        this.startsound =  Gdx.audio.newSound(Gdx.files.internal("../dk.sdu.se4.core/src/main/resources/sound/Zombiestart.mp3"));
        this.playsound =  Gdx.audio.newSound(Gdx.files.internal("../dk.sdu.se4.core/src/main/resources/sound/ZombiePlay.mp3"));
        this.exitsound =  Gdx.audio.newSound(Gdx.files.internal("../dk.sdu.se4.core/src/main/resources/sound/Zombieexit.mp3"));
    }
    
            

    
    public void show() {
        this.addsoundWithDelay(this.startsound,2);
    }

    @Override
    public void render(float f) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        this.game.batch.begin();
        this.game.batch.draw(this.background,(float)(this.game.width/2)-(this.background.getWidth()/2),(float) (this.game.height/2)-(this.background.getHeight()/2));
        this.game.batch.draw(this.headline,(float)(this.game.width/2)-(this.headline.getWidth()/2), (float) (this.game.height/1.333));

        insertExitButton();
        insertPlayButton();
        this.game.batch.end();
        
    }
    private void addsoundWithDelay(Sound sound, int delayTime){
        sound.setVolume(sound.play(),0.1f);
        //sound.play();

        logger.info("Sound play {}", sound);
        try {
            TimeUnit.SECONDS.sleep(delayTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void insertExitButton(){
        if(Gdx.input.getX()< (this.game.width/2.66)+this.exitbtn.getWidth()&& Gdx.input.getX()>(this.game.width/2.66) &&
                Gdx.input.getY()<(this.game.height/1.7)+this.exitbtn.getHeight() && Gdx.input.getY()>(this.game.height/1.7)){
            this.game.batch.draw(this.exitbtn,(float)(this.game.width/2)-(this.exitbtn.getWidth()/2),(float) (this.game.height/3));
            if(Gdx.input.isTouched()){
                addsoundWithDelay(this.exitsound,2);
                Gdx.app.exit();
            }
        }else{
            this.game.batch.draw(this.exitActivebtn,(float)(this.game.width/2)-(this.exitActivebtn.getWidth()/2),(float) (this.game.height/3));
        }
    }
    private void insertPlayButton(){
        if(Gdx.input.getX()< (this.game.width/2.66)+this.playbtn.getWidth()&& Gdx.input.getX()>(this.game.width/2.66) &&
                Gdx.input.getY()<(this.game.height/2.7)+this.playbtn.getHeight() && Gdx.input.getY()>(this.game.height/2.7)){
            this.game.batch.draw(this.playbtn,(float)(this.game.width/2)-(this.playbtn.getWidth()/2),(float) (this.game.height/2));
            if(Gdx.input.isTouched()){
                addsoundWithDelay(this.playsound,2);
                this.dispose();
                game.setScreen(new GameScreen(this.game));
            }
        }else{
            this.game.batch.draw(this.playActivebtn,(float)(this.game.width/2)-(this.playActivebtn.getWidth()/2),(float) (this.game.height/2));
        }
    }
    @Override
    public void resize(int i, int i1) {
    
    }

    @Override
    public void pause() {
        logger.info("Pause {}", this);
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
       
    }

    @Override
    public void dispose() {
        logger.info("Dispose  {}", this);
    }
    
}
