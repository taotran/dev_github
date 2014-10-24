package de.laudert.taotv.service.user;

import de.laudert.taotv.domain.user.User;
import de.laudert.taotv.domain.user.UserSession;
import de.laudert.taotv.exception.UserLoggedOutException;
import de.laudert.taotv.exception.UserNotLogoutException;
import de.laudert.taotv.repository.user.UserSessionRepository;
import de.laudert.taotv.service.EntityServiceBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

/**
 * User: tvt
 * Date: 10/16/14
 * Time: 2:03 PM
 */
@Service
@Transactional
public class UserSessionServiceBean extends EntityServiceBean<UserSession> implements UserSessionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserSessionService.class);

    @Autowired
    private UserSessionRepository userSessionRepository;

    @Override
    public UserSession findBySessionId(String sessionId) {
        return userSessionRepository.findBySessionId(sessionId);
    }

    @Override
    public UserSession loginUserSession(User user, String sessionId) {
        LOGGER.info("==================on register new login user session information==================");
        UserSession userSession = findBySessionId(sessionId);
        if (userSession != null) {
            throw new UserNotLogoutException(userSession.getUser().getUsername(), sessionId);
        }

        userSession = new UserSession();
        userSession.setLoginTimestamp(new Timestamp(System.currentTimeMillis()));
        userSession.setUser(user);
        userSession.setLogoutTimestamp(null);
        return userSession;
    }

    @Override
    public UserSession logoutUserSession(String sessionId) {
        UserSession userSession = findBySessionId(sessionId);
        if (userSession != null) {
            if (userSession.getLogoutTimestamp() != null) {
                throw new UserLoggedOutException(userSession.getUser().getUsername(), sessionId);
            }
            else {
                userSession.setLogoutTimestamp(new Timestamp(System.currentTimeMillis()));
            }
        }
        return null;
    }
}

