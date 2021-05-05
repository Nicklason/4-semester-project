/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.tile;

import dk.sdu.se4.common.service.MapService;

/**
 *
 * @author Kasper
 */
public class TileCore {
    protected MapService mapService=null;
    
    public void addMapService(MapService mapService) {
        this.mapService = mapService;
    }

    public void removeMapService(MapService mapService) {
        this.mapService = null;
    }
}
