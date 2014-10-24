package de.laudert.taotv.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: tvt
 * Date: 10/20/14
 * Time: 2:13 PM
 */
public class UserNotLogoutException extends RuntimeException {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserNotLogoutException.class);

    public UserNotLogoutException(String username, String sessionId) {
        LOGGER.debug("User {} with Session Id {} has not logged out yet!", username, sessionId);
    }
}
