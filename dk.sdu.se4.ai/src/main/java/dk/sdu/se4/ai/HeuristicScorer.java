package dk.sdu.se4.ai;

import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.PositionPart;

public class HeuristicScorer implements ScorerSerrvice{
  @Override
  public double computeCostScore(Entity start, Entity target) {
    PositionPart startPos = start.getPart(PositionPart.class);
    PositionPart targetPos = target.getPart(PositionPart.class);
    double ac = Math.abs(targetPos.getY() - startPos.getY());
    double cb = Math.abs(targetPos.getX() - startPos.getX());
    return 5 * Math.hypot(ac, cb);
  }
}
