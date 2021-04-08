package dk.sdu.se4.common.entity.part;

import dk.sdu.se4.common.entity.Entity;

public class TimePart implements EntityPart {

    private float time;

    public TimePart(float time) {
        this.time = time;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    @Override
    public void process(Entity e) {
    }
}