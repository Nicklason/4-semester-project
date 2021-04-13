package dk.sdu.se4.gamedata;

import dk.sdu.se4.common.service.GameDataService;

/**
 *
 * @author Lucas
 * @author Frederik
 */
public class GameData implements GameDataService {

    protected int points = 0;

    public int getPoints() {
        return this.points;
    }

    public void addPoints(int points) {
        this.points += points;
    }     

    public void removePoints(int points) {
        this.points -= points;
    }

}
