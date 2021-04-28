package dk.sdu.se4.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.EntityTypePart;
import dk.sdu.se4.common.entity.part.ImagePart;
import dk.sdu.se4.common.entity.part.AnimationPart;
import dk.sdu.se4.common.entity.part.PositionPart;
import dk.sdu.se4.common.service.GameService;
import dk.sdu.se4.common.service.MapService;
import dk.sdu.se4.common.service.ProcessorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GameScreen implements Screen {
  private final static Logger logger = LoggerFactory.getLogger(GameScreen.class);

  private GameService game;
  private MapService mapService=null;
  private Texture ui;
  
  private int timer = 1;



  public GameScreen(GameService gameCore) {
    this.game=gameCore;
    this.ui = new Texture("../dk.sdu.se4.screen/src/main/resources/img/UI.png");
    if(this.mapService==null){
      this.mapService=gameCore.getMapService();
    }




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
        //this.game.getBatch().setProjectionMatrix(game.getCamera().combined);

        // starting the drawing
        this.game.getBatch().begin();
        // the Mapservices validation for running the program
        if ( this.mapService != null) {
            updateProcessors();
            drawEntitys();
        }else{
            logger.error("mapservices is {}", this.mapService);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
          this.pause();
          this.game.addScreen(new Menu(this.game));
        }
        if(Gdx.input.isKeyPressed(Input.Keys.P)){
            this.pause();
            this.game.addScreen(new ShopScreen(this.game));
        }
        // Draw the User interface
        this.game.getBatch().draw(ui,0,0);
        this.game.getBatch().end();
  }
  // updating the processes in the gameScreen
  private void updateProcessors() {

    for (ProcessorService processorService : game.getProcessorServices()) {
      processorService.process();
    }
  }
  // Draw the Game Entitys and objects to the Screen/Batch
  private void drawEntitys() {
    for (Entity entity :  this.mapService.getEntities()) {
      EntityTypePart type = entity.getPart(EntityTypePart.class);
      ImagePart imagePart = entity.getPart(ImagePart.class);
      AnimationPart animationPart = entity.getPart(AnimationPart.class);
      PositionPart p = entity.getPart(PositionPart.class);


    if (imagePart != null) {
        this.game.getBatch().draw(imagePart.getTexture(), p.getX(), p.getY());
    }
      
    timer++;

    if (animationPart!=null){
        this.game.getBatch().draw(animationPart.getAnimationFrame(0,8,1+(int)(timer/80)), p.getX(), p.getY());
        animationPart.nullTexture();
        //animationPart.getAnimation(1).draw(this.batch);
        //animationPart.getAnimation(1).setPosition(p.getX(), p.getY());

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

}
