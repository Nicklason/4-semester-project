package dk.sdu.se4.ai;

import dk.sdu.se4.common.entity.Entity;


public interface ScorerSerrvice {

  double computeCostScore(Entity start, Entity target);
}
