package dk.sdu.se4.common.entity.part;

import dk.sdu.se4.common.entity.Entity;

public class UIPart implements  EntityPart{

  public enum Type {
    BUTTON, BACKGROUND, IMAGE
  }
  private Type type;
  private boolean isActive;
  private String name;

  public UIPart(Type type, boolean isActive, String name) {
    this.type = type;
    this.isActive = isActive;
    this.name = name;
  }

  public Type getType() {
    return type;
  }

  public void setType(Type type) {
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isActive() {
    return isActive;
  }

  public void setActive(boolean active) {
    isActive = active;
  }

  @Override
  public void process(Entity entity) {
    SpritePart sp =entity.getPart(SpritePart.class);
    if(isActive){
      sp.setLayer(103);
    }else{
      sp.setLayer(101);
    }
  }
}
