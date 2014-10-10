package de.laudert.taotv.exception;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * User: tvt
 * Date: 10/10/14
 * Time: 1:45 PM
 */
public class UserNotFoundException extends UsernameNotFoundException {

    public UserNotFoundException(String message) {
        super(message);
    }
}
