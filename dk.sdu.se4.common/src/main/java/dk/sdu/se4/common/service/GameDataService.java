package dk.sdu.se4.common.service;

/**
 *
 * @author Lucas
 * @author Frederik
 */
public interface GameDataService {
    public int getPoints();
    
    public void addPoints(int points);

    public void removePoints(int points);
    
    public void setDeltaTime(float deltaTime);
    
    public float getDeltaTime();
}
