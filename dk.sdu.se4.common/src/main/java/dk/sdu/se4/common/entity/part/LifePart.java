/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.common.entity.part;

import dk.sdu.se4.common.entity.Entity;

/**
 *
 * @author Steffen and Kasper Jalris
 */
public class LifePart implements EntityPart{

    private int max_hit_point;
    private int hit_point;
    private boolean alive;

    public LifePart(int hit_point) {
        this.hit_point = hit_point;
        this.max_hit_point = hit_point;
        this.alive = this.hit_point > 0;
    }
    
    public void hit(int amount){
        this.hit_point-= amount;
         this.alive = this.hit_point > 0;
        
    }
    public void addHitPoint(int amount){
        this.hit_point+=amount;
        if (this.hit_point>this.max_hit_point){
            this.hit_point=this.max_hit_point;
        }
    }

    public void setMAX_HIT_POINTS(int MAX_HIT_POINTS) {
        this.max_hit_point = MAX_HIT_POINTS;
    }

    @Override
    public void process(Entity entity) {
     
    }
    

}
