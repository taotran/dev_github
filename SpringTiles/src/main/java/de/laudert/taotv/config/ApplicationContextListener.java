package de.laudert.taotv.config;

import de.laudert.taotv.manager.MigrationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;

/**
 * User: tvt
 * Date: 10/24/14
 * Time: 2:21 PM
 */
public class ApplicationContextListener implements ApplicationListener<ApplicationEvent> {

    @Autowired
    private MigrationManager migrationManager;

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.getProperty(StandardEnvironment.ACTIVE_PROFILES_PROPERTY_NAME);
        if (event instanceof ContextRefreshedEvent) {
            System.out.println("CONTEXT REFRESH EVENT");
            migrationManager.migrate();
        }
        else if (event instanceof ContextClosedEvent) {
            System.out.println("SERVER IS BEING SHUTDOWN");
        }
        else if (event instanceof AuthenticationSuccessEvent) {
            System.out.println("Login Success Event Raised");
        }
    }
}
