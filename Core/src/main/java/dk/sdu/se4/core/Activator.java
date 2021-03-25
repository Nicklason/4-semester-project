package dk.sdu.se4.core;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    LwjglApplication application = null;

    public void start(BundleContext context) throws Exception {
        LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
        cfg.title = "4. semester project";
        cfg.width = 800;
        cfg.height = 600;
        cfg.useGL30 = false;
        cfg.resizable = false;

        application = new LwjglApplication(new Game(), cfg);
    }

    public void stop(BundleContext context) throws Exception {
        // TODO: Figure out how to stop the game without stopping the entire process
        application.exit();
    }

}
