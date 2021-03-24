package dk.sdu.se4.map;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
    
    ServiceRegistration serviceRegistration;

    public void start(BundleContext context) throws Exception {
        serviceRegistration = context.registerService(MapServiceImplementation.class.getName(), new MapServiceImplementation(), null);
    }

    public void stop(BundleContext context) throws Exception {
        serviceRegistration.unregister();
    }

}

