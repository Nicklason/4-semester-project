package dk.sdu.se4.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.EntityTypePart;
import dk.sdu.se4.common.entity.part.ImagePart;
import dk.sdu.se4.common.entity.part.PositionPart;
import dk.sdu.se4.common.entity.part.VisibilityPart;
import dk.sdu.se4.common.service.ProcessorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GameScreen implements Screen {
  private final static Logger logger = LoggerFactory.getLogger(GameScreen.class);

  private GameCore game;

  public GameScreen(GameCore gameCore) {
    this.game=gameCore;
  }

  @Override
  public void show() {

  }

  @Override
  public void render(float deltaTime) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        this.game.batch.begin();
        if ( this.game.mapService != null) {
            updateProcessors();
            drawEnitys();
        }else{
            logger.error("mapservices is {}", this.game.mapService);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
          this.pause();
          this.game.setScreen(new StartMenu(this.game));
        }

        this.game.batch.end();
  }
  private void updateProcessors() {

    for (ProcessorService processorService : game.processorServiceslist) {
      processorService.process();
    }
  }

  private void drawEnitys() {
    for (Entity entity :  this.game.mapService.getEntities()) {
      EntityTypePart type = entity.getPart(EntityTypePart.class);
      ImagePart imagePart = entity.getPart(ImagePart.class);
      PositionPart p = entity.getPart(PositionPart.class);
      VisibilityPart vb = entity.getPart(VisibilityPart.class);
      System.out.println(entity.getClass().getName());
      if (imagePart != null) {
        this.game.batch.draw(imagePart.getTexture(), p.getX(), p.getY());
      }


    }

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
