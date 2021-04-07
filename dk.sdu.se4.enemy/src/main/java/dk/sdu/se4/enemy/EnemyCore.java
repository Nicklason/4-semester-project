/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.enemy;

import dk.sdu.se4.common.service.MapService;

/**
 *
 * @author steff
 */
public class EnemyCore {
    protected MapService mapService=null;
    
    public void addMapService(MapService mapService) {
        this.mapService = mapService;
        System.out.println("ADDED MapService TO Enemy "+this.mapService.getClass().toString());
    }

    public void removeMapService(MapService mapService) {
        this.mapService = null;
        System.out.println("REMOVED MapService FROM Enemy "+this.mapService.getClass().toString());
    }
    
}