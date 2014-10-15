package de.laudert.taotv.service.login;

import de.laudert.taotv.domain.user.UserSession;
import de.laudert.taotv.exception.UserNotFoundException;
import de.laudert.taotv.repository.user.UserSessionRepository;
import de.laudert.taotv.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

/**
 * User: tvt
 * Date: 10/15/14
 * Time: 3:19 PM
 */
@Service
public class LoginServiceBean implements LoginService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserSessionRepository userSessionRepository;

    @Autowired
    private CustomSessionRegistry sessionRegistry;

    @Override
    public UserDetails loadUserByUsername(String username) throws UserNotFoundException {
        final de.laudert.taotv.domain.user.User user = userService.findByUsername(username);
        if (user == null) {
            throw new UserNotFoundException("User not found!");
        }
        final List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority(user.getRole()));
        User u = new User(user.getUsername(), user.getPassword(), authorities);
        UserSession userSession = new UserSession();
        userSession.setLoginTimestamp(new Timestamp(System.currentTimeMillis()));
        userSession.setSessionId("");
        userSession.setUser(user);
        save(userSession);
        return u;
    }

    @Override
    public UserSession save(UserSession userSession) {
        return userSessionRepository.save(userSession);
    }
}
