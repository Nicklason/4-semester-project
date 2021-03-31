package dk.sdu.se4.core;

import dk.sdu.se4.common.service.MapService;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.GL20;

public final class Game implements ApplicationListener  {
    private MapService mapService = null;
    
    LwjglApplication application = null;
    
    public Game() {
        LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
        cfg.title = "4. semester project";
        cfg.width = 800;
        cfg.height = 600;
        cfg.useGL30 = false;
        cfg.resizable = false;

        application = new LwjglApplication(this, cfg);
        
        //System.out.println("CREATED Game");
    }

    @Override
    public void create() {}

    @Override
    public void render() {
        // Clear screen to black
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void resize(int width, int height) {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void dispose() {}

    public void addMapService(MapService mapService) {
        this.mapService = mapService;
        //System.out.println("ADDED MapService TO Game");
    }

    public void removeMapService(MapService mapService) {
        this.mapService = null;
        //System.out.println("REMOVED MapService FROM Game");
    }
}
