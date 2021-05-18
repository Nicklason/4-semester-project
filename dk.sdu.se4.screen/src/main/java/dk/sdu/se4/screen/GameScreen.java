package dk.sdu.se4.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.*;
import dk.sdu.se4.common.service.GameService;
import dk.sdu.se4.common.service.MapService;
import dk.sdu.se4.common.service.PostProcessorService;
import dk.sdu.se4.common.service.ProcessorService;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GameScreen extends SpriteHandler implements Screen {
    private final static Logger logger = LoggerFactory.getLogger(GameScreen.class);

    private GameService game;
    private MapService mapService=null;
    private Texture ui;
    private Stage stage;
    private SpriteBatch spriteBatch;
    private QuickSort quicksort;

    int x = 0;
    int y = 0;
    private static final double DIAGONAL_SCALING_CONSTANT = Math.sqrt(2) / 2;

    public GameScreen(GameService gameCore) {
        this.game=gameCore;
        this.stage=new Stage();
        this.spriteBatch = new SpriteBatch();
        if(this.mapService==null){
          this.mapService=gameCore.getMapService();

        }
        this.quicksort= new QuickSort();
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

        OrthographicCamera cam = (OrthographicCamera) game.getCamera();
        cam.position.set(game.getWidth()/2, game.getHeight()/2,0);
        //this.game.getBatch().setProjectionMatrix(game.getCamera().combined);
        this.game.getGameDataService().setDeltaTime(Gdx.graphics.getDeltaTime());

        
        //translate camera on keypresses
        int oldX = x;
        int oldY = y;
        if(Gdx.input.isKeyPressed(Input.Keys.W)) {
            y+=10;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S)) {
            y-=10;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A)) {
            x-=10;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)) {
            x+=10;
        }
        if(oldX!=x && oldY!=y) {
            x = (int) Math.round((x-oldX) * DIAGONAL_SCALING_CONSTANT) + oldX;
            y = (int) Math.round((y-oldY) * DIAGONAL_SCALING_CONSTANT) + oldY;
        }
        cam.translate(x, y);
        cam.update();
        this.game.getBatch().setProjectionMatrix(cam.combined);
        // starting the drawing
        this.game.getBatch().begin();
        this.game.getBatch().end();
        // the Mapservices validation for running the program
        if ( this.mapService != null) {
            // Hack for removeTime in TimePart :::: FIX THIS PLZ SOMEONE plez
            for(Entity e : this.mapService.getEntities()) {
                TimePart tp = e.getPart(TimePart.class);
                if(tp != null) {
                    tp.removeTime(this.game.getGameDataService().getDeltaTime());
                }
            }
            updateProcessors();
            draw();
            updatePostProcessors();

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

        //TODO Update with SpritePart
       // this.game.getBatch().draw(ui,x,y);
       // this.game.getBatch().end();
  

    }
    // updating the processes in the gameScreen
    private void updateProcessors() {
        for (ProcessorService processorService : game.getProcessorServices()) {
          processorService.process();
        }
    }

    private void updatePostProcessors(){
        for (PostProcessorService postProcessorService : game.getPostProcessorServiceslist()) {
            postProcessorService.process();
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


        quicksort.quickSort(entityList, 0, entityList.size()-1);

        for (Entity entity : entityList) {
            SpritePart spritePart = entity.getPart(SpritePart.class);
            PositionPart positionPart = entity.getPart(PositionPart.class);
            if (spritePart.getLayer()<100){
                drawSprite(spritePart, positionPart);
            }

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
