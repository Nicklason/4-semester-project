package dk.sdu.se4.common.service;

import dk.sdu.se4.common.entity.Entity;

import java.util.Collection;
import java.util.List;


public interface AIControlService {
    void pathFinding(Entity start, Entity target);

    SelectedAction choseAction();

    public enum SelectedAction {
        UP,DOWN,LEFT,RIGHT
    }
}
