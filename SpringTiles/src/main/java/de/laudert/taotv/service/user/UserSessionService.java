package de.laudert.taotv.service.user;

import de.laudert.taotv.domain.user.User;
import de.laudert.taotv.domain.user.UserSession;
import de.laudert.taotv.service.EntityService;

/**
 * User: tvt
 * Date: 10/16/14
 * Time: 2:02 PM
 */
public interface UserSessionService extends EntityService<UserSession> {

    public UserSession findBySessionId(String sessionId);

    public UserSession loginUserSession(User user, String sessionId);

    public UserSession logoutUserSession(String sessionId);
}
