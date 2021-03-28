/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.common.data;

import dk.sdu.se4.common.data.GameObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author steff
 */
public class GameSpace {

    private Map<String, GameObject> gameMap;

    public GameSpace() {
        this.gameMap = new HashMap<>();
    }

    public void addGameObject(GameObject gameObject) {
        this.gameMap.put(gameObject.getID(), gameObject);
    }

    public void removeGameObject(String gameObjectID) {
        this.gameMap.remove(gameObjectID);
    }

    public Collection<GameObject> getAllGameObjects() {
        return this.gameMap.values();
    }

    public <E extends GameObject> List<GameObject> getEntities(Class<E>... gameobjectsTypes) {
        List<GameObject> all = new ArrayList<>();
        for (GameObject e : getAllGameObjects()) {
            for (Class<E> entityType : gameobjectsTypes) {
                if (entityType.equals(e.getClass())) {
                    all.add(e);
                }
            }
        }
        return all;
    }

    public GameObject getGameObject(String gameObjectID) {
        return this.gameMap.get(gameObjectID);
    }

}
