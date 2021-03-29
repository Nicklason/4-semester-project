/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.core;

import com.badlogic.gdx.Game;
import dk.sdu.se4.common.data.ScreenHolder;
import dk.sdu.se4.common.services.IGameScreenService;
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
public class GameStarter extends Game{
    private ScreenHolder screenHolder;
    private final Lookup lookup = Lookup.getDefault();
    private Lookup.Result<IGameScreenService> result;
    private List<IGameScreenService> gameScreens;

    

    public GameStarter() {
        this.gameScreens = new CopyOnWriteArrayList<>();
        this.screenHolder = new ScreenHolder();
        result = this.lookup.lookupResult(IGameScreenService.class);
        result.addLookupListener(this.lookupListener);
        result.allItems();

        for (IGameScreenService plugin : result.allInstances()) {
            System.out.println("Found : " + plugin.getClass().toString());
            plugin.ScreenProcessor(screenHolder);
            gameScreens.add(plugin);
        }
       
    }
  
    

    @Override
    public void create() {
        setScreen(this.screenHolder.getScreen("MenuScreen"));
        
        
    }

    @Override
    public void resize(int i, int i1) {
        super.resize(i1, i1);
    }

    @Override
    public void render() {
       super.render();
    }

    @Override
    public void pause() {
       super.pause();
    }

    @Override
    public void resume() {
      super.resume();
    }

    @Override
    public void dispose() {
       super.dispose();
        
    }
    
  
    
    private final LookupListener lookupListener = new LookupListener() {
        @Override
        public void resultChanged(LookupEvent le) {

            Collection<? extends IGameScreenService> updated = result.allInstances();

            for (IGameScreenService us : updated) {
                // Newly installed modules
                if (!gameScreens.contains(us)) {
                    us.ScreenProcessor(screenHolder);
                    gameScreens.add(us);
                }
            }
           
        }

    };

    
    

}
