package de.laudert.taotv.repository.user;

import de.laudert.taotv.domain.user.User;
import de.laudert.taotv.repository.EntityRepository;

/**
 * User: tvt
 * Date: 9/26/14
 * Time: 4:25 PM
 */
public interface UserRepository extends EntityRepository<User> {

    User findByUsername(String username);
}
