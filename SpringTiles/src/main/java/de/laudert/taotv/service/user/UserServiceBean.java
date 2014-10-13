package de.laudert.taotv.service.user;

import de.laudert.taotv.domain.user.User;
import de.laudert.taotv.repository.user.UserRepository;
import de.laudert.taotv.service.EntityServiceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: tvt
 * Date: 9/25/14
 * Time: 5:43 PM
 */
@Service
public class UserServiceBean extends EntityServiceBean<User> implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
