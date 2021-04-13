/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.common.entity.part;

import dk.sdu.se4.common.entity.Entity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kasper
 */
public class NodePart implements EntityPart {
    List<Entity> list = new ArrayList<>();
    
    public NodePart() {
    }

    @Override
    public void process(Entity entity) {
    }
    
}
