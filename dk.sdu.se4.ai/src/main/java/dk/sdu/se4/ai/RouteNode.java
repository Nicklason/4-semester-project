package dk.sdu.se4.ai;

import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.commonnode.Node;

public class RouteNode implements Comparable<RouteNode>{

  private final Entity current;
  private Entity previous;
  private double pathScore;
  private double estimatedScore;

  public RouteNode(Entity current) {
    this(current, null, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
  }

  public RouteNode(Entity current, Entity previous, double pathScore, double estimatedScore) {
    this.current = current;
    this.previous = previous;
    this.pathScore = pathScore;
    this.estimatedScore = estimatedScore;
  }

  @Override
  public int compareTo(RouteNode o) {
    if (this.estimatedScore > o.estimatedScore) {
      return 1;
    } else if (this.estimatedScore < o.estimatedScore) {
      return -1;
    } else {
      return 0;
    }
  }

  public Entity getCurrent() {
    return current;
  }

  public Entity getPrevious() {
    return previous;
  }

  public void setPrevious(Entity previous) {
    this.previous = previous;
  }

  public double getPathScore() {
    return pathScore;
  }

  public void setPathScore(double pathScore) {
    this.pathScore = pathScore;
  }

  public double getEstimatedScore() {
    return estimatedScore;
  }

  public void setEstimatedScore(double estimatedScore) {
    this.estimatedScore = estimatedScore;
  }

  @Override
  public String toString() {
    return "RouteNode{" +
            "current=" + current +
            ", previous=" + previous +
            ", pathScore=" + pathScore +
            ", estimatedScore=" + estimatedScore +
            '}';
  }
}
