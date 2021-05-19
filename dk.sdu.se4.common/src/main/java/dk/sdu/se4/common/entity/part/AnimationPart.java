package dk.sdu.se4.common.entity.part;

import dk.sdu.se4.common.entity.Entity;

public class AnimationPart  implements EntityPart {
  private final String path;
  private final float width;
  private final  float height;
  private int layer;


  public AnimationPart(String path, float width, float height, int layer) {
    this.path = path;
    this.width = width;
    this.height = height;
    this.layer = layer;
  }

  public AnimationPart(String path, float width, float height) {
    this.path = path;
    this.width = width;
    this.height = height;
  }

  public String getPath() {
    return path;
  }

  public float getWidth() {
    return width;
  }

  public float getHeight() {
    return height;
  }

  public int getLayer() {
    return layer;
  }

  public void setLayer(int layer) {
    this.layer = layer;
  }

  @Override
  public void process(Entity entity) {

  }
}
