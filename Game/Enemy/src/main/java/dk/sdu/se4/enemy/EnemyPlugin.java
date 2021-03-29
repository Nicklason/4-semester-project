/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.se4.enemy;

import dk.sdu.se4.common.data.GameObject;
import dk.sdu.se4.common.data.GameSpace;
import dk.sdu.se4.common.data.parts.PositionPart;
import dk.sdu.se4.common.data.parts.TexturPart;
import dk.sdu.se4.common.services.IPluginService;
import java.awt.Point;
import java.io.File;
import org.openide.util.lookup.ServiceProvider;
import org.openide.util.lookup.ServiceProviders;

/**
 *
 * @author steff
 */
@ServiceProviders(value = {
    @ServiceProvider(service = IPluginService.class),})
public class EnemyPlugin implements IPluginService{
    private GameObject enemy;

    @Override
    public void load(GameSpace gameSpace) {
        System.out.println("Enemy Load");
        this.enemy = createEnemy();
        gameSpace.addGameObject(this.enemy);
    }

    @Override
    public void unload(GameSpace gameSpace) {
        System.out.println("Enemy Unload");
    }

    private GameObject createEnemy() {
       GameObject gameObject = new Enemy();
       gameObject.addPart(new PositionPart(new Point(10, 10)));
       PositionPart p = gameObject.getPart(PositionPart.class);
       File file =new File("C:/Users/steff/OneDrive/Documents/GitHub/4-semester-project/Game/Enemy/src/main/resources/Alien.png");
       gameObject.addPart(new TexturPart(file,p.getPoint(), 32, 32));
       
       return gameObject;
    }
    
}
