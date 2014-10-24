package de.laudert.taotv.config;

import de.laudert.taotv.service.user.UserService;
import de.laudert.taotv.service.user.UserSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionDestroyedEvent;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * User: tvt
 * Date: 10/15/14
 * Time: 4:04 PM
 */
public class CustomSessionRegistry extends SessionRegistryImpl {

    @Autowired
    private UserSessionService userSessionService;

    @Autowired
    private UserService userService;

    @Override
    public void registerNewSession(String sessionId, Object principal) {
        UserDetails userDetails = (UserDetails) principal;
        userSessionService.loginUserSession(userService.findByUsername(userDetails.getUsername()), sessionId);
        super.registerNewSession(sessionId, principal);
    }

    @Override
    public void onApplicationEvent(SessionDestroyedEvent event) {
        super.onApplicationEvent(event);
    }

    @Override
    public SessionInformation getSessionInformation(String sessionId) {
        return super.getSessionInformation(sessionId);
    }

    @Override
    public void removeSessionInformation(String sessionId) {
        userSessionService.logoutUserSession(sessionId);
        super.removeSessionInformation(sessionId);
    }
}
