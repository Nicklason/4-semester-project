package dk.sdu.se4.astar;

public interface HeuristicFunktion {

  double getEstimatedCost (GraphNode from, GraphNode to );
}
