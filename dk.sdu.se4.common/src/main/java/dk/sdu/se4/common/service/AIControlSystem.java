package dk.sdu.se4.common.service;

import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.PositionPart;

import java.util.List;

public interface AIControlSystem {


    PositionPart pathFinding(Entity start, Entity target);


    void grideBulder(Entity target);
}
