package dk.sdu.se4.astar;

import java.util.*;

public class AStar {
  public static List<GraphNode> search(GraphNode start, GraphNode target, GraphWeightFunktion weightFunktion, HeuristicFunktion heuristicFunktion) {
    PriorityQueue<Entry> open = new PriorityQueue<>();
    Set<GraphNode> closed = new HashSet<>();
    Map<GraphNode, Double> distanceMap = new HashMap<>();
    Map<GraphNode, GraphNode> parrents = new HashMap<>();


    open.add(new Entry(start, 0.0));
    distanceMap.put(start, 0.0);
    parrents.put(start, null);
    while (!open.isEmpty()) {
      GraphNode currentNode = open.remove().getNode();
      System.out.println(currentNode);
      if (currentNode.equals(target)) {

        return tracebackPath(currentNode, parrents);

      }
      if (closed.contains(currentNode)) {
        continue;
      }
      closed.add(currentNode);
      for (GraphNode childnode : currentNode.getChildren()) {

        if (closed.contains(currentNode)) {
          continue;
        }

        double tentativeDistance = distanceMap.get(currentNode) + weightFunktion.get(currentNode, childnode);

        if (!distanceMap.containsKey(childnode) || distanceMap.get(childnode) > tentativeDistance) {
          distanceMap.put(childnode, tentativeDistance);
          parrents.put(childnode, currentNode);
          open.add(new Entry(childnode, tentativeDistance + heuristicFunktion.getEstimatedCost(childnode, target)));


        }
      }
    }
    return new ArrayList<>();
  }

  private static List<GraphNode> tracebackPath(GraphNode target, Map<GraphNode, GraphNode> parrents) {
    List<GraphNode> path = new ArrayList<>();
    GraphNode currnetnode = target;
    while (currnetnode != null) {
      path.add(currnetnode);
      System.out.println("path " + currnetnode);
      currnetnode = parrents.get(currnetnode);
    }
    Collections.reverse(path);

    return path;
  }

  private static final class Entry implements Comparable<Entry> {
    private final GraphNode node;
    private final double distance;

    private Entry(GraphNode node, double distance) {
      this.node = node;
      this.distance = distance;
    }

    public GraphNode getNode() {
      return this.node;
    }

    @Override
    public int compareTo(Entry o) {
      return Double.compare(this.distance, o.distance);
    }
  }


}
