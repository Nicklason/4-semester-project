package dk.sdu.se4.bullet;

import dk.sdu.se4.common.service.MapService;

public class BulletCore {
    protected MapService mapService=null;
    
    public void addMapService(MapService mapService) {
        this.mapService = mapService;
    }

    public void removeMapService(MapService mapService) {
        this.mapService = null;
    }
    
}