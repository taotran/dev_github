package de.laudert.taotv.repository;

import de.laudert.taotv.domain.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * User: tvt
 * Date: 10/13/14
 * Time: 3:19 PM
 */
public interface EntityRepository<T extends AbstractEntity> extends JpaRepository<T, Long> {

}
