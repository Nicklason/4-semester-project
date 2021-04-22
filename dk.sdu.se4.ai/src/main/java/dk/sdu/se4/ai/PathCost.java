package dk.sdu.se4.ai;

import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.NodePart;

public class PathCost implements ScorerSerrvice{
  @Override
  public double computeCostScore(Entity start, Entity target) {
    NodePart np = target.getPart(NodePart.class);
    if (np != null) {
      if (np.getState() == NodePart.State.CLOSED) {
        return Double.POSITIVE_INFINITY;
      } else {
        return 32;
      }
    }else{
      return 0;
    }
  }
}
