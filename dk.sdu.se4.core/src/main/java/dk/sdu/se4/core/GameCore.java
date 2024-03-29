package dk.sdu.se4.core;

import com.badlogic.gdx.*;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import dk.sdu.se4.common.service.*;
import dk.sdu.se4.commongameinput.GameInput;
import java.util.ArrayList;
import java.util.List;

import dk.sdu.se4.screen.StartMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class GameCore extends Game implements GameService {
    private final static Logger logger = LoggerFactory.getLogger(GameCore.class);
    LwjglApplication application = null;
    private MapService mapService=null;
    private GameInput gameInput = null;
    private List<PluginService> pluginlist = new ArrayList<>();
    private List<PostProcessorService> postProcessorServiceslist = new ArrayList<>();
    private List<ProcessorService> processorServiceslist = new ArrayList<>();
    private SpriteBatch batch;
    private ShapeRenderer shapeRenderer;
    private int width = 800;
    private int height = 600;
    private OrthographicCamera camera;
    private GameDataService gameData;
    
    public GameCore() {
        logger.info("Creating {}", this);
        LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
        cfg.title = "4. semester project";
        cfg.width = width;
        cfg.height = height;
        cfg.useGL30 = false;
        cfg.resizable = false;
        application = new LwjglApplication(this, cfg);
        logger.debug("Creating {}", application);
        camera = new OrthographicCamera();
        camera.setToOrtho(true, this.width, this.height);
        camera.translate(0, 0);
    }
 
    @Override
    public void create() {
        this.batch = new SpriteBatch();
        this.shapeRenderer = new ShapeRenderer();
         setScreen(new StartMenu(this));
    }

    public List<ProcessorService> getProcessorServiceslist() {
        return processorServiceslist;
    }
    
    public List<PostProcessorService> getPostProcessorServiceslist() {
        return postProcessorServiceslist;
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

    
    public void addScreen(Screen screen){
        this.setScreen(screen);
    }

    @Override
    public SpriteBatch getBatch() {
        return this.batch;
    }
    
    public ShapeRenderer getShapeRenderer() {
        return this.shapeRenderer;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public List<ProcessorService> getProcessorServices() {
        return this.processorServiceslist;
    }

    @Override
    public MapService getMapService() {
        return this.mapService;
    }

    public GameDataService getGameDataService() {
        return this.gameData;
    }

    @Override
    public OrthographicCamera getCamera() {
        return this.camera;
    }

    public void addGameData(GameDataService gameData) {
        this.gameData = gameData;
    }

    public void removeGameData(GameDataService gameData) {
        this.gameData = null;
    }
}
