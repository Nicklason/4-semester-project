package dk.sdu.se4.astar;

public class EuckideanHeuristicFunktion implements HeuristicFunktion{

  private final GraphCordinbtes cordinbtes;

  public EuckideanHeuristicFunktion(GraphCordinbtes cordinbtes) {
    this.cordinbtes = cordinbtes;
  }

  @Override
  public double getEstimatedCost(GraphNode from, GraphNode to) {
    return cordinbtes.get(from).distance(cordinbtes.get(to));
  }
}
