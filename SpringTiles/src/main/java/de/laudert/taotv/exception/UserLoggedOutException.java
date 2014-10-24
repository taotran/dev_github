package de.laudert.taotv.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: tvt
 * Date: 10/20/14
 * Time: 2:24 PM
 */
public class UserLoggedOutException extends RuntimeException {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserNotLogoutException.class);

    public UserLoggedOutException(String username, String sessionId) {
        LOGGER.debug("User {} with Session Id {} logged out!", username, sessionId);
    }
}
