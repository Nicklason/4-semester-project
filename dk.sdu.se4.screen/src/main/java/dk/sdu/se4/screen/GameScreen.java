package dk.sdu.se4.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.*;
import dk.sdu.se4.common.service.GameService;
import dk.sdu.se4.common.service.MapService;
import dk.sdu.se4.common.service.ProcessorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Comparator;

public class GameScreen extends SpriteHandler implements Screen {
  private final static Logger logger = LoggerFactory.getLogger(GameScreen.class);

  private GameService game;
  private MapService mapService=null;
  private Texture ui;
  private Stage stage;
  private SpriteBatch spriteBatch;




  public GameScreen(GameService gameCore) {
    this.game=gameCore;
    this.stage=new Stage();
    this.spriteBatch = new SpriteBatch();
    if(this.mapService==null){
      this.mapService=gameCore.getMapService();

    }
    loadAssets(this.mapService);



  }

  @Override
  public void show() {

  }

  @Override
  public void render(float deltaTime) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        // set the position for the cammara

        game.getCamera().position.set(game.getWidth()/2, game.getHeight()/2,0);


        // the Mapservices validation for running the program
        if ( this.mapService != null) {
            updateProcessors();
            draw();
        }else{
            logger.error("mapservices is {}", this.mapService);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
          this.pause();
          this.game.addScreen(new StartMenu(this.game));
        }
        if(Gdx.input.isKeyPressed(Input.Keys.P)){
            this.pause();
            this.game.addScreen(new ShopScreen(this.game));
        }
        // Draw the User interface

  }
  // updating the processes in the gameScreen
  private void updateProcessors() {

    for (ProcessorService processorService : game.getProcessorServices()) {
      processorService.process();
    }
  }

  private void draw() {
    ArrayList<Entity> entityList = new ArrayList<>();

    // Populate list
    for (Entity entity : this.mapService.getEntities()) {
      SpritePart spritePart = entity.getPart(SpritePart.class);
      PositionPart positionPart = entity.getPart(PositionPart.class);
      if (spritePart != null && positionPart != null) {
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
    for (Entity entity : entityList) {
      SpritePart spritePart = entity.getPart(SpritePart.class);
      PositionPart positionPart = entity.getPart(PositionPart.class);
      if (spritePart.getLayer()<100){
        drawSprite(spritePart, positionPart);
      }

    }


  }

  @Override
  public void resize(int i, int i1) {

  }

  @Override
  public void pause() {
    logger.info("Pause Game at {}", this);
  }

  @Override
  public void resume() {
    logger.info("Resume Game at {}", this);
  }

  @Override
  public void hide() {

  }

  @Override
  public void dispose() {

  }



  private void drawSprite(SpritePart spritePart, PositionPart positionPart) {
    this.spriteBatch.begin();
    Texture texture = this.assetManager.get(spritePart.getSpritePath(), Texture.class);
    Sprite sprite = new Sprite(texture);
    sprite.setX(positionPart.getX());
    sprite.setY(positionPart.getY());
    sprite.setAlpha(spritePart.getAlpha());
    sprite.setSize(spritePart.getWidth(), spritePart.getHeight());
    sprite.draw(this.spriteBatch);
    this.spriteBatch.end();
  }

}
