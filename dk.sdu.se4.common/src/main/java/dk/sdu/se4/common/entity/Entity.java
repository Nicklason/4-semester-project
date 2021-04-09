package dk.sdu.se4.common.entity;

import dk.sdu.se4.common.entity.part.EntityPart;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Entity {
    
    private final static Logger log = LoggerFactory.getLogger(Entity.class);
    private final String id;
    
    
    private final Map<Class, EntityPart> partStorage;

    public String getId() {
        return this.id;
    }

    
    public Entity() {
        log.debug("Createt new {}",this.getClass().toString());
        this.id = UUID.randomUUID().toString();
        this.partStorage = new ConcurrentHashMap<>();
        
    }
    
    public void addPart(EntityPart entitypart){
        this.partStorage.put(entitypart.getClass(), entitypart);
    }

    public void removePart(Class partClass){
        this.partStorage.remove(partClass);
    }

    public <E extends EntityPart> E getPart(Class partClass){
        return (E) this.partStorage.get(partClass);
    }
}