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

    @Override
    public UserDetails loadUserByUsername(String username) throws UserNotFoundException {
        final de.laudert.taotv.domain.user.User user = userService.findByUsername(username);
        if (user == null) {
            throw new UserNotFoundException("User not found!");
        }
        final List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority(user.getRole()));
        return new User(user.getUsername(), user.getPassword(), authorities);
    }

    @Override
    public UserSession save(UserSession userSession) {
        return userSessionRepository.save(userSession);
    }
}
