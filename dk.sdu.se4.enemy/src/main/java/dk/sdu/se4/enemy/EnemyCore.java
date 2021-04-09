/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.enemy;

import dk.sdu.se4.common.service.MapService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author steff
 */
public class EnemyCore {
    protected MapService mapService=null;
    protected Logger log = LoggerFactory.getLogger(this.getClass());
    
    public void addMapService(MapService mapService) {
        this.mapService = mapService;
    }

    public void removeMapService(MapService mapService) {
        this.mapService = null;
    }

    
    
}
