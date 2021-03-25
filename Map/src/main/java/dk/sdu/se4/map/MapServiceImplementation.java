package dk.sdu.se4.map;

import dk.sdu.se4.common.entity.Entity;
import dk.sdu.se4.common.service.MapService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MapServiceImplementation implements MapService {

    private int height = 600;
    private int width = 600;
    private Map<String, Entity> entities;

    public MapServiceImplementation() {
        this.entities = new HashMap();
    }

    public int getHeight() {
        return this.height;
    }

    public int getWeight() {
        return this.width;
    }

    public void addEntity(Entity entity) {
        this.entities.put(entity.getId(), entity);
    }

    public Collection<Entity> getEntities() {
        return this.entities.values();
    }

    public <E extends Entity> Collection<Entity> getEntities(Class<E> entityType) {
        Collection<Entity> match = new ArrayList();

        for (Entity entity : getEntities()) {
            if (entityType.equals(entity.getClass())) {
                match.add(entity);
            }
        }

        return match;
    }

    public void removeEntity(Entity entity) {
        this.entities.remove(entity.getId());
    }

    public void removeEntities(Collection<Entity> removeEntities) {
        for (Entity entity : removeEntities) {
            this.entities.remove(entity);
        }
    }

}
