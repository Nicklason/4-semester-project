package dk.sdu.se4.Equipment;

import dk.sdu.se4.common.service.MapService;

public class EquipmentCore {
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