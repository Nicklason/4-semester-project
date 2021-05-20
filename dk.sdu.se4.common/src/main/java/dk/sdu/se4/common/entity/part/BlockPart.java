package dk.sdu.se4.common.entity.part;

import dk.sdu.se4.common.entity.Entity;

public class BlockPart implements EntityPart{
  private int height;
  private int width;
  private int X;
  private int Y;

  public BlockPart(int height, int width, int x, int y) {
    this.height = height;
    this.width = width;
    X = x;
    Y = y;
  }

  public int getHeight() {
    return height;
  }

  public int getWidth() {
    return width;
  }

  public int getX() {
    return X;
  }

  public int getY() {
    return Y;
  }

  @Override
  public void process(Entity entity) {
    PositionPart pp = entity.getPart(PositionPart.class);
    this.X=pp.getX();
    this.Y=pp.getY();
  }
}
