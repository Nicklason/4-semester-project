package dk.sdu.se4.common.entity.part;

import dk.sdu.se4.common.entity.Entity;

public class SpritePart implements EntityPart {
  private String spritePath;
  private float width;
  private float height;
  private int layer;
  private int alpha;

  public SpritePart(String spritePath, float width, float height){
    this.spritePath = spritePath;
    this.width = width;
    this.height = height;
    this.layer = 0;
    this.alpha = 1;

  }

  public SpritePart(String spritePath, float width, float height, int layer){
    this(spritePath, width, height);
    this.layer = layer;
  }

  public SpritePart(String spritePath, float width, float height, int layer, int alpha){
    this(spritePath, width, height, layer);
    this.alpha = alpha;
  }

  public String getSpritePath() {
    return spritePath;
  }

  public void setSpritePath(String spritePath) {
    this.spritePath = spritePath;
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

  public int getAlpha() {
    return alpha;
  }

  public void setWidth(float width) {
    this.width = width;
  }

  public void setHeight(float height) {
    this.height = height;
  }

  public void setLayer(int layer) {
    this.layer = layer;
  }

  public void setAlpha(int alpha) {
    this.alpha = alpha;
  }

  @Override
  public void process(Entity entity) {

  }
}
