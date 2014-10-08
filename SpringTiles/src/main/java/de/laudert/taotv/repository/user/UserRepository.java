package de.laudert.taotv.repository.user;

import de.laudert.taotv.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * User: tvt
 * Date: 9/26/14
 * Time: 4:25 PM
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
