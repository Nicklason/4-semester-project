package dk.sdu.se4.core;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.CollisionPart;
import dk.sdu.se4.common.entity.part.ImagePart;
import dk.sdu.se4.common.entity.part.PositionPart;
import dk.sdu.se4.common.service.GameDataService;
import dk.sdu.se4.common.service.MapService;
import dk.sdu.se4.common.service.PluginService;
import dk.sdu.se4.common.service.PostProcessorService;
import dk.sdu.se4.common.service.ProcessorService;
import dk.sdu.se4.commongameinput.GameInput;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Game implements ApplicationListener {

    private final static Logger logger = LoggerFactory.getLogger(Game.class);
    private MapService mapService = null;
    private GameInput gameInput = null;
    private GameDataService gameData = null;

    private List<PluginService> pluginlist = new ArrayList<>();
    private List<PostProcessorService> postProcessorServiceslist = new ArrayList<>();
    private List<ProcessorService> processorServiceslist = new ArrayList<>();
    private SpriteBatch batch;
    private OrthographicCamera cam;
    private ShapeRenderer sr;
    private boolean debug = true;

    LwjglApplication application = null;

    public Game() {
        logger.info("Creating {}", this);
        LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
        cfg.title = "4. semester project";
        cfg.width = 800;
        cfg.height = 600;
        cfg.useGL30 = false;
        cfg.resizable = false;

        application = new LwjglApplication(this, cfg);
        logger.debug("Creating {}", application);
        cam = new OrthographicCamera(1280, 720);
        cam.translate(Gdx.graphics.getWidth() / 2, Gdx.graphics.getWidth() / 2, 0);

    }

    @Override
    public void create() {
        this.batch = new SpriteBatch();
        this.sr = new ShapeRenderer();
    }

    @Override
    public void render() {
        // Clear screen to black
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (this.mapService!=null){
            updateProcessors();
            updatePostProcessors();
            drawEnitys();

        }
    }

    private void updateProcessors() {
        
        for (ProcessorService processorService : this.processorServiceslist) {
            processorService.process();
        }
    }
    
    private void updatePostProcessors() {
        
        for (PostProcessorService processorService : this.postProcessorServiceslist) {
            processorService.process();
        }
    }

    private void drawEnitys() {
            for (Entity entity : this.mapService.getEntities()) {
                ImagePart imagePart = entity.getPart(ImagePart.class);
                PositionPart p = entity.getPart(PositionPart.class);
                if (imagePart != null) {
                    this.batch.begin();
                    this.batch.draw(imagePart.getTexture(), p.getX(), p.getY());
                    this.batch.end();
                }
                
                if (this.debug == true) {
                    CollisionPart collisionPart = entity.getPart(CollisionPart.class);
                
                    if (collisionPart == null || p == null) {
                        continue;
                    }


                    sr.begin(ShapeRenderer.ShapeType.Line);
                    // sr.rect(p.getX(), p.getY(), collisionPart.getWidth(), collisionPart.getHeight());

                    // Bottom
                    sr.line(p.getX(), p.getY(), p.getX() + collisionPart.getWidth(), p.getY(), Color.BLUE, Color.BLUE);
                    // Left
                    sr.line(p.getX(), p.getY(), p.getX(), p.getY() + collisionPart.getHeight(), Color.BLUE, Color.BLUE);
                    // Right
                    sr.line(p.getX() + collisionPart.getWidth(), p.getY(), p.getX() + collisionPart.getWidth(), p.getY() + collisionPart.getHeight(), Color.BLUE, Color.BLUE);
                    // Top
                    sr.line(p.getX(), p.getY() + collisionPart.getHeight(), p.getX() + collisionPart.getWidth(), p.getY() + collisionPart.getHeight(), Color.BLUE, Color.BLUE);

                    sr.end();
                }
            }
        
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {

    }

    public void addMapService(MapService mapService) {
        logger.debug("Add {}", mapService.getClass().getName());
        this.mapService = mapService;
    }

    public void removeMapService(MapService mapService) {
        logger.debug("Remove {}", mapService.getClass().getName());
        this.mapService = null;
    }

    public void addPlugin(PluginService pluginService) {
        if (this.mapService != null) {
            logger.debug("Add {}", pluginService.getClass().getName());
            pluginService.load();
            this.pluginlist.add(pluginService);
        } else {
            logger.error("Map Service is null");
        }

    }

    public void removePlugin(PluginService pluginService) {
        logger.debug("Remove {}", pluginService.getClass().getName());
        pluginService.unload();
        this.pluginlist.remove(pluginService);

    }

    public void addGameInput(GameInput gameInput) {
        if (this.mapService != null) {
            logger.debug("Add {}", gameInput.getClass().getName());
            this.gameInput = gameInput;
            Gdx.input.setInputProcessor((InputProcessor) gameInput);
        } else {
            logger.error("Map Service is null ");
        }

    }

    public void removeGameInput(GameInput gameInput) {
        logger.debug("Remove {}", gameInput.getClass().getName());
        this.gameInput = null;
    }

    public void addProcessorService(ProcessorService ProcessorService) {
        if (this.mapService != null) {
            logger.debug("Add {}", ProcessorService.getClass().getName());
            this.processorServiceslist.add(ProcessorService);
        } else {
            logger.error("Map Service is null {}");
        }

    }

    public void removeProcessorService(ProcessorService ProcessorService) {
        logger.debug("Remove {}", ProcessorService.getClass().getName());
        this.processorServiceslist.remove(ProcessorService);
    }

    public void addPostProcessorService(PostProcessorService postProcessorService) {
        if (this.mapService != null) {
            logger.debug("Add {}", postProcessorService.getClass());
            this.postProcessorServiceslist.add(postProcessorService);
        } else {
            logger.error("Map Service is null {}");
        }

    }

    public void removePostProcessorService(PostProcessorService postProcessorService) {
        logger.debug("Remove {}", postProcessorService.getClass().getName());
        this.postProcessorServiceslist.remove(postProcessorService);
    }

}
