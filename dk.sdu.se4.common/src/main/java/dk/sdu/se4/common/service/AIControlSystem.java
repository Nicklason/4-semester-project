package dk.sdu.se4.common.service;

import dk.sdu.se4.common.entity.Entity;

public interface AIControlSystem {


    int[][] pathFinding(Entity start, Entity target);




    void mapbuilder(Entity target);
}
