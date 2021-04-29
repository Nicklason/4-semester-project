package dk.sdu.se4.common.entity.part;

import dk.sdu.se4.common.entity.Entity;

/**
 *
 * @author Lucas
 * @author Frederik
 */
public class ScorePart implements EntityPart {
    private int currentScore;

    /**
     * Creates new instance of ScorePart
     * @param score Score of entity
     */
    public ScorePart(int score) {
        this.currentScore = score;
    }

    /**
     * Decrease score with amount
     * @param amount The amount to decrease
     */
    public void decreaseScore(int amount){
        this.currentScore -= amount;
        this.scoreChanged();
    }

    /**
     * Increase score with amount
     * @param amount The amount to increase
     */
    public void increaseScore(int amount){
        this.currentScore += amount;
        this.scoreChanged();
    }
    
    /**
     * Method to call when score changes
     */
    private void scoreChanged() {
        if (this.currentScore < 0) {
            this.currentScore = 0;
        }
    }
    
    @Override
    public void process(Entity entity) {}
}
