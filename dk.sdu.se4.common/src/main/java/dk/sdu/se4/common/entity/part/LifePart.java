package dk.sdu.se4.common.entity.part;

import dk.sdu.se4.common.entity.Entity;

/**
 *
 * @author Steffen and Kasper Jalris
 */
public class LifePart implements EntityPart{
    private int maxHealth;
    private int currentHealth;

    public int getCurrentHealth() {
        return currentHealth;
    }

    /**
     * Creates new instance of LifePart
     * @param maxHealth Max health
     */
    public LifePart(int maxHealth) {
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
    }
    
    /**
     * Remove health
     * @param amount The amount to remove
     */
    public void removeHealth(int amount){
        this.currentHealth -= amount;
        this.healthChanged();
    }

    /**
     * Add health
     * @param amount The amount to add 
     */
    public void addHealth(int amount){
        this.currentHealth += amount;
        this.healthChanged();
    }

    /**
     * Set max health
     * @param maxHealth New max health
     */
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
        this.healthChanged();
    }

    /**
     * Checks if current health is greater than 0
     * @return true if above 0, false if not
     */
    public boolean isAlive() {
        return this.currentHealth > 0;
    }
    
    /**
     * Method to call when health changes
     */
    private void healthChanged() {
        if (this.currentHealth > this.maxHealth){
            this.currentHealth = this.maxHealth;
        }
    }

    @Override
    public void process(Entity entity) {}
}
