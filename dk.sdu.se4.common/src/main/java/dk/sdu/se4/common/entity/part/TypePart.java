package dk.sdu.se4.common.entity.part;

import dk.sdu.se4.common.entity.Entity;


public class TypePart implements EntityPart {



  private final Type type;

  public TypePart(Type type) {
    this.type = type;
  }

  public Type getType() {
    return type;
  }

  @Override
  public void process(Entity entity) {

  }




}
