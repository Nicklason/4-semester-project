/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.player;

import dk.sdu.se4.common.service.MapService;

/**
 *
 * @author Kasper
 */
public class PlayerCore {
    protected MapService mapService=null;
    
    public void addMapService(MapService mapService) {
        this.mapService = mapService;
        System.out.println("ADDED MapService TO Player "+this.mapService.getClass().toString());
    }

    public void removeMapService(MapService mapService) {
        this.mapService = null;
        System.out.println("REMOVED MapService FROM Player "+this.mapService.getClass().toString());
    }
}
