/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.common.data;

import dk.sdu.se4.common.services.IGameScreenService;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Steffen Vitten
 */
public class ScreenHolder {
    private Map<String, IGameScreenService> screenMap;

    public ScreenHolder() {
        this.screenMap = new HashMap<>();
    }
    
    public void addScreen(IGameScreenService screen){
        this.screenMap.put(screen.getScreenName(), screen);
    }
    public void removeScreen(IGameScreenService gameScreenService){
        this.screenMap.remove(gameScreenService.getScreenName());
    }
    public void removeScreen(String screenName){
        this.screenMap.remove(screenName);
    }
    public Collection<IGameScreenService> getAllScreens() {
        return this.screenMap.values();
    }
    public IGameScreenService getScreen(String screenName){
        return this.screenMap.get(screenName);
    }
    
    
}
