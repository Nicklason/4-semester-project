package dk.sdu.se4.core;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.GL20;
import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.service.MapService;
import dk.sdu.se4.common.service.PluginService;
import dk.sdu.se4.common.service.PostProcessorService;
import dk.sdu.se4.common.service.ProcessorService;
import java.util.ArrayList;
import java.util.List;

public final class Game implements ApplicationListener  {
    private MapService mapService = null;
    
    private List<PluginService> pluginlist = new ArrayList<>();
    private List<PostProcessorService> postProcessorServiceslist = new ArrayList<>();
    private List<ProcessorService> processorServiceslist = new ArrayList<>();
    ;

    
   
    
    
    LwjglApplication application = null;
    
    public Game() {
        LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
        cfg.title = "4. semester project";
        cfg.width = 800;
        cfg.height = 600;
        cfg.useGL30 = false;
        cfg.resizable = false;
      
        application = new LwjglApplication(this, cfg);
        
        //System.out.println("CREATED Game");
    }

    @Override
    public void create() {
    for(PluginService p :pluginlist){
        p.load();
    }
    
    }

    @Override
    public void render() {
        // Clear screen to black
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        
        
        for(Entity entity: this.mapService.getEntities()){
            
        }
        for (ProcessorService processorService:this.processorServiceslist){
            processorService.process();
        }
       
    }

    @Override
    public void resize(int width, int height) {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void dispose() {
       
    }

    public void addMapService(MapService mapService) {
        this.mapService = mapService;
        
        System.out.println("ADDED MapService TO Game to "+this.mapService.toString());
    }

    public void removeMapService(MapService mapService) {
        this.mapService = null;
        System.out.println("REMOVED MapService FROM Game to "+this.mapService.toString());
    }
    public void addPlugin(PluginService pluginService){
        this.pluginlist.add(pluginService);
    }
    public void removePlugin(PluginService pluginService){
        this.pluginlist.remove(pluginService);
        
    }
    
    public void addProcessorService(ProcessorService ProcessorService){
        this.processorServiceslist.add(ProcessorService);
    }
    
    public void removeProcessorService(ProcessorService ProcessorService){
        this.processorServiceslist.remove(ProcessorService);
        
    }
    
    public void addPostProcessorService(PostProcessorService postProcessorService){
        this.postProcessorServiceslist.add(postProcessorService);
    }
    
    public void removePostProcessorService(PostProcessorService postProcessorService){
        this.postProcessorServiceslist.remove(postProcessorService);
    }
    
    
    
}
