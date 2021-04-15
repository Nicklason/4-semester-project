package dk.sdu.se4.core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.EntityTypePart;
import dk.sdu.se4.common.entity.part.ImagePart;
import dk.sdu.se4.common.entity.part.PositionPart;
import dk.sdu.se4.common.entity.part.VisibilityPart;
import dk.sdu.se4.common.service.MapService;
import dk.sdu.se4.common.service.PluginService;
import dk.sdu.se4.common.service.PostProcessorService;
import dk.sdu.se4.common.service.ProcessorService;
import dk.sdu.se4.commongameinput.GameInput;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class GameCore extends Game  {

    private final static Logger logger = LoggerFactory.getLogger(GameCore.class);
    LwjglApplication application = null;
    protected MapService mapService=null;
    private GameInput gameInput = null;
    protected List<PluginService> pluginlist = new ArrayList<>();
    protected List<PostProcessorService> postProcessorServiceslist = new ArrayList<>();
    protected List<ProcessorService> processorServiceslist = new ArrayList<>();
    protected SpriteBatch batch;
    protected int width = 800;
    protected int height = 600;
    
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
       

    }
 
    @Override
    public void create() {
       this.batch = new SpriteBatch();
        setScreen(new StartMenu(this));
       
    }





    public List<ProcessorService> getProcessorServiceslist() {
        return processorServiceslist;
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
