package dk.sdu.se4.common.entity.part;

import dk.sdu.se4.common.entity.Entity;

public class PathPart implements EntityPart {
  private int loop=0;
  private int[][] path;

  public PathPart(int[][] path) {
    this.path = path;
  }

  public int[][] getPath() {
    return path;
  }

  public void setPath(int[][] path) {
    this.path = path;
  }

  @Override
  public void process(Entity entity) {
    if (loop>=0 && this.getPath()!=null){
      PositionPart pp = entity.getPart(PositionPart.class);
      pp.translate( this.getPath()[loop][1],this.getPath()[loop][0]);
        System.out.println(pp.getX()+"  "+pp.getY());
      loop++;
      if (loop>10){
        this.setPath(null);
        loop =0;
      }
    }
  }
}
