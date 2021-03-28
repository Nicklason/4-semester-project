/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.core;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import dk.sdu.se4.common.data.GameSpace;
import dk.sdu.se4.common.services.IFunktionProcessingService;
import dk.sdu.se4.common.services.IGameObjectProcesssingService;
import dk.sdu.se4.common.services.IPluginService;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.openide.util.Lookup;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;
/**
 *
 * @author steff
 */
public class Game  implements ApplicationListener{
    private GameSpace gamespace;
    
    private final Lookup lookup = Lookup.getDefault();
    private Lookup.Result<IPluginService> result;
    private List<IPluginService> gamePlugins ;
    private List<IFunktionProcessingService> funktionProcessings;
    private List<IGameObjectProcesssingService> iGameObjectProcesssingServices;
    
    
    
    public Game() {
        this.gamePlugins = new CopyOnWriteArrayList<>();
        this.funktionProcessings = new CopyOnWriteArrayList<>();
        this.iGameObjectProcesssingServices = new CopyOnWriteArrayList<>(); 
        LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
        cfg.title = "Semester 4";
        cfg.width = 800;
        cfg.height = 600;
        cfg.useGL30 = false;
        cfg.resizable = false;
        this.gamespace=new GameSpace();

        new LwjglApplication(this, cfg);
    }

    @Override
    public void create() {
        System.out.println("Start Game");
        
        result = this.lookup.lookupResult(IPluginService.class);
        result.addLookupListener(this.lookupListener);
        result.allItems();

        
        for (IPluginService plugin : result.allInstances()) {
            System.out.println("Found : "+plugin.getClass().toString());
            plugin.load(this.gamespace);
            gamePlugins.add(plugin);
        }
        System.out.println("************************");
    }

    @Override
    public void resize(int i, int i1) {
        
    }

    @Override
    public void render() {
        
       for (IFunktionProcessingService funktionProcessingService: getFunktionProcessingServices()){
           funktionProcessingService.funktionProcess(this.gamespace);
       }
       for (IGameObjectProcesssingService gameObjectProcesssingService: getGameObjectProcesssingServices()){
           gameObjectProcesssingService.process(this.gamespace);
       }
    }

    @Override
    public void pause() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void resume() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dispose() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     private Collection<? extends IGameObjectProcesssingService> getGameObjectProcesssingServices() {
        return lookup.lookupAll(IGameObjectProcesssingService.class);
    }

    private Collection<? extends IFunktionProcessingService> getFunktionProcessingServices() {
        return lookup.lookupAll(IFunktionProcessingService.class);
    }
    
    
    
    
    
    private final LookupListener lookupListener = new LookupListener() {
        @Override
        public void resultChanged(LookupEvent le) {

            Collection<? extends IPluginService> updated = result.allInstances();

            for (IPluginService us : updated) {
                // Newly installed modules
                if (!gamePlugins.contains(us)) {
                    us.load(gamespace);
                    gamePlugins.add(us);
                }
            }
            for (IPluginService gs : gamePlugins) {
                if (!updated.contains(gs)) {
                    gs.unload(gamespace);
                    gamePlugins.remove(gs);
                }
            }
        }

    };
    
}
