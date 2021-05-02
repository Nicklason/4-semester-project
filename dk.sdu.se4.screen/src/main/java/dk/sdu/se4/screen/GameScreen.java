package dk.sdu.se4.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.CollisionPart;
import dk.sdu.se4.common.entity.part.EntityTypePart;
import dk.sdu.se4.common.entity.part.ImagePart;
import dk.sdu.se4.common.entity.part.PositionPart;
import dk.sdu.se4.common.service.GameService;
import dk.sdu.se4.common.service.MapService;
import dk.sdu.se4.common.service.PostProcessorService;
import dk.sdu.se4.common.service.ProcessorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GameScreen implements Screen {
  private final static Logger logger = LoggerFactory.getLogger(GameScreen.class);

  private GameService game;
  private MapService mapService=null;
  private Texture ui;



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

        // the Mapservices validation for running the program
        if ( this.mapService != null) {
            updateProcessors();
            updatePostProcessors();
            drawEntitys();
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
        this.game.getBatch().begin();
        this.game.getBatch().draw(ui,0,0);
        this.game.getBatch().end();
  }
  // updating the processes in the gameScreen
  private void updateProcessors() {

    for (ProcessorService processorService : game.getProcessorServices()) {
      processorService.process();
    }
  }
  
    private void updatePostProcessors() {

      for (PostProcessorService processorService : game.getPostProcessorServiceslist()) {
        processorService.process();
      }
    }
  
    // Draw the Game Entitys and objects to the Screen/Batch
    private void drawEntitys() {
        for (Entity entity :  this.mapService.getEntities()) {
            EntityTypePart type = entity.getPart(EntityTypePart.class);
            ImagePart imagePart = entity.getPart(ImagePart.class);
            PositionPart p = entity.getPart(PositionPart.class);


            if (imagePart != null) {
                this.game.getBatch().begin();
                this.game.getBatch().draw(imagePart.getTexture(), p.getX(), p.getY());
                this.game.getBatch().end();
            }

            /*
            // If true the entties collisionbox is shown. If false they dont.
            if (true) {
                CollisionPart collisionPart = entity.getPart(CollisionPart.class);

            if (collisionPart == null) {
                continue;
            }
                
            this.game.getShapeRenderer().begin(ShapeRenderer.ShapeType.Line);

            // Bottom
            this.game.getShapeRenderer().line(p.getX(), p.getY(), p.getX() + collisionPart.getWidth(), p.getY(), Color.BLUE, Color.BLUE);
            // Left
            this.game.getShapeRenderer().line(p.getX(), p.getY(), p.getX(), p.getY() + collisionPart.getHeight(), Color.BLUE, Color.BLUE);
            // Right
            this.game.getShapeRenderer().line(p.getX() + collisionPart.getWidth(), p.getY(), p.getX() + collisionPart.getWidth(), p.getY() + collisionPart.getHeight(), Color.BLUE, Color.BLUE);
            // Top
            this.game.getShapeRenderer().line(p.getX(), p.getY() + collisionPart.getHeight(), p.getX() + collisionPart.getWidth(), p.getY() + collisionPart.getHeight(), Color.BLUE, Color.BLUE);

            this.game.getShapeRenderer().end(); */
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
