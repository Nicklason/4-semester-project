package dk.sdu.se4.Equipment;

import dk.sdu.se4.common.service.MapService;

public class EquipmentCore {
    protected MapService mapService=null;
    
    public void addMapService(MapService mapService) {
        this.mapService = mapService;
        System.out.println("ADDED MapService TO Bullet "+this.mapService.getClass().toString());
    }

    public void removeMapService(MapService mapService) {
        System.out.println("REMOVED MapService FROM Bullet "+this.mapService.getClass().toString());
        this.mapService = null;
    }
    
}