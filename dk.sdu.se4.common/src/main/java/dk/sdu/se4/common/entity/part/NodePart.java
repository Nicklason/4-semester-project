/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.common.entity.part;

import dk.sdu.se4.common.entity.Entity;

import java.util.*;

/**
 *
 * @author Kasper
 */
public class NodePart implements EntityPart {

    Map<Entity, PositionPart> entitymap = new HashMap<>();
    public static enum State { UNVISITED, OPEN, CLOSED };
    private State state = State.UNVISITED;
    private boolean blocked = false;

    private double g; // cost
    private double h; // heuristic

    
    public NodePart() {
    }
    public void clear(){
        this.entitymap.clear();
    }

    public void add(Entity entity, PositionPart positionPart){
        if (this.entitymap.containsKey(entity)){
            this.entitymap.remove(entity);
        }
        this.entitymap.put(entity, positionPart);
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public double getG() {
        return g;
    }

    public void setG(double g) {
        this.g = g;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public Map<Entity, PositionPart> getNodeEntities(){
        return this.entitymap;
    }


    @Override
    public void process(Entity entity) {


    }
    
}
