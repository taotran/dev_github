package de.laudert.taotv.service.user;

import de.laudert.taotv.domain.user.User;
import de.laudert.taotv.service.EntityService;

/**
 * User: tvt
 * Date: 9/25/14
 * Time: 5:42 PM
 */
public interface UserService extends EntityService<User>{

    public User findByUsername(String username);

}
