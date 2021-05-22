package dk.sdu.se4.astar;

import java.util.*;

public class AStar {
  private static int DEFAULT_HV_COST = 1;
  private static int DEFAULT_DIAGONAL_COST = 5;
  private int hvCost;
  private int diagonalCost;
  private Node[][] searchArea;
  private PriorityQueue<Node> openList;
  private Set<Node> closedSet;
  private Node startNode;
  private Node targetNode;

  public AStar(int x, int y, Node startNode, Node targetNode, int hvCost, int diagonalCost) {
    this.hvCost = hvCost;
    this.diagonalCost = diagonalCost;
    setStartNode(startNode);
    setTarggetNode(targetNode);
    this.searchArea = new Node[y][x];
    this.openList = new PriorityQueue<Node>(new Comparator<Node>() {
      @Override
      public int compare(Node node0, Node node1) {
        return Double.compare(node0.getF(), node1.getF());
      }
    });
    setNodes();
    this.closedSet = new HashSet<>();
  }

  public AStar(int x, int y, Node startNode, Node targetNode) {
    this(x, y, startNode, targetNode, DEFAULT_HV_COST, DEFAULT_DIAGONAL_COST);
  }

  private void setNodes() {
    for (int i = 0; i < searchArea.length; i++) {
      for (int j = 0; j < searchArea[0].length; j++) {
        Node node = new Node(i, j);
        node.calculateHeuristic(getFinalNode());
        this.searchArea[i][j] = node;
      }
    }
  }

  public void setBlocks(List<List<Integer>> blocksArray) {
      for (List<Integer> ls : blocksArray){
          setBlock(ls.get(0), ls.get(1));
      }

  }

  public List<Node> findPath() {
    openList.add(startNode);
    while (!isEmpty(openList)) {
      Node currentNode = openList.poll();
      closedSet.add(currentNode);
      if (currentNode.equals(targetNode)) {
        return getPath(currentNode);
      } else {
        addAdjacentNodes(currentNode);
      }
    }
    return new ArrayList<Node>();
  }

  private List<Node> getPath(Node currentNode) {
    List<Node> path = new ArrayList<Node>();
    path.add(currentNode);
    Node parent;
    while ((parent = currentNode.getParent()) != null) {
      path.add(0, parent);
      currentNode = parent;
    }
    return path;
  }

  private void addAdjacentNodes(Node currentNode) {
    addAdjacentUpperXPos(currentNode);
    addAdjacentMiddleXPos(currentNode);
    addAdjacentLowerXPos(currentNode);
  }

  private void addAdjacentLowerXPos(Node currentNode) {
    int row = currentNode.getY();
        int col = currentNode.getX();
        int lowerRow = row + 1;
        if (lowerRow < getSearchArea().length) {
            if (col - 1 >= 0) {
                checkNode(currentNode, col - 1, lowerRow, getDiagonalCost()); // Comment this line if diagonal movements are not allowed
            }
            if (col + 1 < getSearchArea()[0].length) {
                checkNode(currentNode, col + 1, lowerRow, getDiagonalCost()); // Comment this line if diagonal movements are not allowed
            }
            checkNode(currentNode, col, lowerRow, getHvCost());
        }
    }




  private void addAdjacentMiddleXPos(Node currentNode) {
    int row = currentNode.getY();
        int col = currentNode.getX();
        int middleRow = row;
        if (col - 1 >= 0) {
            checkNode(currentNode, col - 1, middleRow, getHvCost());
        }
        if (col + 1 < getSearchArea()[0].length) {
            checkNode(currentNode, col + 1, middleRow, getHvCost());
        }
    }

  private void addAdjacentUpperXPos(Node currentNode) {
     int row = currentNode.getY();
        int col = currentNode.getX();
        int upperRow = row - 1;
        if (upperRow >= 0) {
            if (col - 1 >= 0) {
                checkNode(currentNode, col - 1, upperRow, getDiagonalCost()); // Comment this if diagonal movements are not allowed
            }
            if (col + 1 < getSearchArea()[0].length) {
                checkNode(currentNode, col + 1, upperRow, getDiagonalCost()); // Comment this if diagonal movements are not allowed
            }
            checkNode(currentNode, col, upperRow, getHvCost());
        }
    }

  private void checkNode(Node currentNode, int x, int y, int cost) {
    
    Node adjacentNode = getSearchArea()[x][y];
    if (!adjacentNode.isBlock() && !getClosedSet().contains(adjacentNode)) {
      if (!getOpenList().contains(adjacentNode)) {
        adjacentNode.setNodeData(currentNode, cost);
        getOpenList().add(adjacentNode);
      } else {
        boolean changed = adjacentNode.checkBetterPath(currentNode, cost);
        if (changed) {
          getOpenList().remove(adjacentNode);
          getOpenList().add(adjacentNode);
        }
      }
    }
  }



  private boolean isEmpty(PriorityQueue<Node> openList) {
    return openList.size() == 0;
  }

  private void setBlock(int y, int x) {
    this.searchArea[y][x].setBlock(true);
  }

  public Node getInitialNode() {
    return startNode;
  }

  public void setStartNode(Node initialNode) {
    this.startNode = initialNode;
  }

  public Node getFinalNode() {
    return targetNode;
  }

  public void setTarggetNode(Node finalNode) {
    this.targetNode = finalNode;
  }

  public Node[][] getSearchArea() {
    return searchArea;
  }

  public void setSearchArea(Node[][] searchArea) {
    this.searchArea = searchArea;
  }

  public PriorityQueue<Node> getOpenList() {
    return openList;
  }

  public void setOpenList(PriorityQueue<Node> openList) {
    this.openList = openList;
  }

  public Set<Node> getClosedSet() {
    return closedSet;
  }

  public void setClosedSet(Set<Node> closedSet) {
    this.closedSet = closedSet;
  }

  public int getHvCost() {
    return hvCost;
  }

  public void setHvCost(int hvCost) {
    this.hvCost = hvCost;
  }

  private int getDiagonalCost() {
    return diagonalCost;
  }

  private void setDiagonalCost(int diagonalCost) {
    this.diagonalCost = diagonalCost;
  }
}
