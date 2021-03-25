/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.common.entity.parts;

import dk.sdu.se4.common.entity.Entity;

/**
 *
 * @author steff
 */
public class LifePart implements EntityPart {

    private int hp;
    private int MAX_HP;
    private boolean alive;

    public LifePart(int MAX_HP) {
        this.hp = MAX_HP;
        this.MAX_HP = MAX_HP;
        this.alive = true;
    }

    public void removeHP(int amount) {
        if (alive) {
            this.hp -= amount;
            if (this.hp <= 0) {
                this.alive = false;
            }
        }
    }

    public void addHP(int amount) {
        if (this.alive) {
            this.hp += amount;
            if (this.hp > this.MAX_HP) {
                this.hp = MAX_HP;
            }

        }
    }

    public void setMAX_HP(int MAX_HP) {
        this.MAX_HP = MAX_HP;
    }

    public int getHp() {
        return hp;
    }

    public int getMAX_HP() {
        return MAX_HP;
    }

    public boolean isAlive() {
        return alive;
    }

    public void process(Entity entity) {

    }

}
