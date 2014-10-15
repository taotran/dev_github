package de.laudert.taotv.service.login;

import de.laudert.taotv.domain.user.UserSession;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * User: tvt
 * Date: 10/10/14
 * Time: 1:37 PM
 */
public interface LoginService extends UserDetailsService {

    public UserSession save(UserSession userSession);
}
