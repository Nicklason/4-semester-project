package dk.sdu.se4.astar;

import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.PositionPart;
import dk.sdu.se4.common.service.AIControlSystem;
import dk.sdu.se4.common.service.MapService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.*;

public class AIControlSystemImp extends Observable implements AIControlSystem {
  private MapService mapService=null;
  protected Logger log = LoggerFactory.getLogger(this.getClass());




  @Override
  public PositionPart pathFinding(Entity start, Entity target) {
    return null;
  }

  @Override
  public void grideBulder(Entity target) {

  }

  public void addMapService(MapService mapService) {
    log.debug("Add Mapservice on {}", this.getClass());
    this.mapService = mapService;
  }

  public void removeMapService(MapService mapService) {
    log.debug("Remove Mapservice from {}", this.getClass());
    this.mapService = null;
  }
}
