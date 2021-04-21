package dk.sdu.se4.node;

import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.entity.part.NodePart;
import dk.sdu.se4.common.entity.part.PositionPart;
import dk.sdu.se4.common.service.MapService;
import dk.sdu.se4.common.service.ProcessorService;
import dk.sdu.se4.commonnode.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NodeProcessor extends NodeCore implements ProcessorService {



  @Override
  public void process() {
    for (Entity n : this.mapService.getEntities(Node.class)){
      for(Entity e: this.mapService.getEntities()){
        if (n!=e){
          PositionPart p = e.getPart(PositionPart.class);
          PositionPart p2 = n.getPart(PositionPart.class);
          if((p.getX()> p2.getX() && p.getX()<p2.getX()+32) &&
                  (p.getY()> p2.getY() && p.getY()<p2.getY()+32)){
            NodePart np = n.getPart(NodePart.class);
            np.add(e, p);
          }

        }
      }

    }


  }


}
