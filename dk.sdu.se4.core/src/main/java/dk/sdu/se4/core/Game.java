package dk.sdu.se4.core;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.GL20;
import dk.sdu.se4.commongameinput.GameInput;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Timer;
import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.AnimationPart;
import dk.sdu.se4.common.entity.part.ImagePart;
import dk.sdu.se4.common.entity.part.PositionPart;
import dk.sdu.se4.common.service.MapService;
import dk.sdu.se4.common.service.PluginService;
import dk.sdu.se4.common.service.PostProcessorService;
import dk.sdu.se4.common.service.ProcessorService;
import java.util.ArrayList;
import java.util.List;

public final class Game implements ApplicationListener {

    private MapService mapService = null;
    private GameInput gameInput = null;
    
    int timer = 1;

    private List<PluginService> pluginlist = new ArrayList<>();
    private List<PostProcessorService> postProcessorServiceslist = new ArrayList<>();
    private List<ProcessorService> processorServiceslist = new ArrayList<>();
    private SpriteBatch batch;
    private OrthographicCamera cam;
    LwjglApplication application = null;

    public Game() {
        LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
        cfg.title = "4. semester project";
        cfg.width = 800;
        cfg.height = 600;
        cfg.useGL30 = false;
        cfg.resizable = false;
        

        application = new LwjglApplication(this, cfg);
        cam = new OrthographicCamera(1280 ,720);
        cam.translate(Gdx.graphics.getWidth()/2, Gdx.graphics.getWidth()/2, 0);
        cam.update();
        //System.out.println("CREATED Game");
    }

    @Override
    public void create() {
        this.batch = new SpriteBatch();
        
        for(PluginService p : this.pluginlist){
            p.load();
        }
        
    }

    @Override
    public void render() {
        // Clear screen to black
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        this.batch.begin();
        
        

        for (ProcessorService processorService : this.processorServiceslist) {
            processorService.process();
        }
        
        for (Entity entity : this.mapService.getEntities()) {
            ImagePart imagePart = entity.getPart(ImagePart.class);
            AnimationPart animationPart = entity.getPart(AnimationPart.class);
            PositionPart p = entity.getPart(PositionPart.class);

            if (imagePart!=null){
                this.batch.draw(imagePart.getTexture(), p.getX(), p.getY());
            }
            System.out.print("seconds : ");
            timer++;
            System.out.println((int)(timer/1000));
            
            if (animationPart!=null){
                this.batch.draw(animationPart.getAnimationFrame(0,8,1+(int)(timer/80)), p.getX(), p.getY());
                //animationPart.getAnimation(1).draw(this.batch);
                //animationPart.getAnimation(1).setPosition(p.getX(), p.getY());
                
            }
        }
        

        batch.end();
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
        this.mapService = mapService;
    }

    public void removeMapService(MapService mapService) {
        this.mapService = null;
        
    }

    public void addPlugin(PluginService pluginService) { 
        this.pluginlist.add(pluginService);
    }

    public void removePlugin(PluginService pluginService) {
        this.pluginlist.remove(pluginService);
    }
    
    public void addGameInput(GameInput gameInput) {
        this.gameInput = gameInput;
        // Cast game input as an InputProcessor (should probably fix this)
        Gdx.input.setInputProcessor((InputProcessor)gameInput);
        //System.out.println("ADDED GameInput TO Game");
    }
    
    public void removeGameInput(GameInput gameInput) {
        this.gameInput = null;
        //System.out.println("REMOVED GameInput FROM Game");
    }

    public void addProcessorService(ProcessorService ProcessorService) {
        this.processorServiceslist.add(ProcessorService);
    }

    public void removeProcessorService(ProcessorService ProcessorService) {
        this.processorServiceslist.remove(ProcessorService);
    }

    public void addPostProcessorService(PostProcessorService postProcessorService) {
        this.postProcessorServiceslist.add(postProcessorService);
    }

    public void removePostProcessorService(PostProcessorService postProcessorService) {
        this.postProcessorServiceslist.remove(postProcessorService);
    }

}
