/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.*;
import dk.sdu.se4.common.service.GameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author steff
 */
public class StartMenu extends SpriteHandler implements Screen{
    private final static Logger logger = LoggerFactory.getLogger(StartMenu.class);
    private GameService game;
    private Sound startsound;
    private Sound playsound;
    private Sound exitsound;
    private SpriteBatch spriteBatch;
    private ArrayList<Entity> entityList = new ArrayList<>();



    public StartMenu(GameService GameCore) {
        this.game = GameCore;
        this.spriteBatch = new SpriteBatch();
        this.startsound =  Gdx.audio.newSound(Gdx.files.internal("../dk.sdu.se4.screen/src/main/resources/sound/Zombiestart.mp3"));
        this.playsound =  Gdx.audio.newSound(Gdx.files.internal("../dk.sdu.se4.screen/src/main/resources/sound/ZombiePlay.mp3"));
        this.exitsound =  Gdx.audio.newSound(Gdx.files.internal("../dk.sdu.se4.screen/src/main/resources/sound/Zombieexit.mp3"));
        this.loadAssets(this.game.getMapService());
    }




    public void show() {
        this.addsoundWithDelay(this.startsound,2);
    }

    @Override
    public void render(float f) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        draw();
    }
    //This feature sets the sound and the delay time for the loop. so that to song is finish before the runtime continues
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
    private void draw() {
        entityList.clear();
        // Populate list
        for (Entity entity : this.game.getMapService().getEntities()) {
            SpritePart spritePart = entity.getPart(SpritePart.class);
            PositionPart positionPart = entity.getPart(PositionPart.class);
            UIPart ap = entity.getPart(UIPart.class);
            if (spritePart != null && positionPart != null && spritePart.getLayer()>100) {
                entityList.add(entity);
            }
        }
        entityList.sort(new Comparator<Entity>() {
            @Override
            public int compare(Entity e1, Entity e2) {
                SpritePart spritePartone = e1.getPart(SpritePart.class);
                SpritePart spriteParttwo = e2.getPart(SpritePart.class);
                return spritePartone.getLayer() - spriteParttwo.getLayer();
            }
        });
        for(Entity entity:entityList){
            SpritePart sp = entity.getPart(SpritePart.class);
            PositionPart ps = entity.getPart(PositionPart.class);
            UIPart ap = entity.getPart(UIPart.class);
            if (ap.getType() == UIPart.Type.BUTTON) {
                if (this.game.getHeight()-Gdx.input.getY()  > ps.getY() && this.game.getHeight()-Gdx.input.getY() < ps.getY() +sp.getHeight() &&
                        Gdx.input.getX() > ps.getX() && Gdx.input.getX()  < ps.getX() + sp.getWidth()) {
                    ap.setActive(true);
                    if(ap.getName()=="play"){
                        if (Gdx.input.isTouched()) {
                            this.game.addScreen(new GameScreen(this.game));
                        }
                    }
                    if(ap.getName()=="exit"){
                        if (Gdx.input.isTouched()) {
                            Gdx.app.exit();
                        }
                    }

                } else {
                    ap.setActive(false);
                }
                ap.process(entity);
            }
        }

        for (Entity entity : entityList) {
            SpritePart spritePart = entity.getPart(SpritePart.class);
            PositionPart positionPart = entity.getPart(PositionPart.class);
            drawSprite(spritePart, positionPart);
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


    private void drawSprite(SpritePart spritePart, PositionPart positionPart) {
        if(spritePart.getAlpha()==1) {
            Texture texture = this.assetManager.get(spritePart.getSpritePath(), Texture.class);
            Sprite sprite = new Sprite(texture);
            sprite.setX(positionPart.getX());
            sprite.setY(positionPart.getY());
            sprite.setAlpha(spritePart.getAlpha());
            sprite.setSize(spritePart.getWidth(), spritePart.getHeight());
            this.spriteBatch.begin();
            sprite.draw(this.spriteBatch);
            this.spriteBatch.end();
        }
    }
    
}
