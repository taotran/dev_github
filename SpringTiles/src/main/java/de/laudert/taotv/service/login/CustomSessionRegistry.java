package de.laudert.taotv.service.login;

import org.springframework.security.core.session.SessionDestroyedEvent;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistryImpl;

/**
 * User: tvt
 * Date: 10/15/14
 * Time: 4:04 PM
 */
public class CustomSessionRegistry extends SessionRegistryImpl {

    @Override
    public void registerNewSession(String sessionId, Object principal) {
        super.registerNewSession(sessionId, principal);
    }

    @Override
    public void onApplicationEvent(SessionDestroyedEvent event) {
        event.getId();
        super.onApplicationEvent(event);
    }

    @Override
    public SessionInformation getSessionInformation(String sessionId) {
        return super.getSessionInformation(sessionId);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
