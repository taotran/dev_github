package de.laudert.taotv.service;

import de.laudert.taotv.domain.AbstractEntity;
import de.laudert.taotv.exception.ItemNotFoundException;
import de.laudert.taotv.repository.EntityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User: tvt
 * Date: 9/26/14
 * Time: 10:05 AM
 */
public class EntityServiceBean<T extends AbstractEntity> implements EntityService<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(EntityServiceBean.class);

    @Autowired
    private EntityRepository<T> entityRepository;

    @Override
    public T findOne(Long id) {
        return entityRepository.findOne(id);
    }

    @Override
    public List<T> findAll() {
        return entityRepository.findAll();
    }

    @Override
    @Transactional
    public void delete(Long id) throws ItemNotFoundException {
        if (findOne(id) == null) {
            throw new ItemNotFoundException("Entity not found. Id: " + id);
        }

        LOGGER.debug("Deleting entity {}");

        entityRepository.delete(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public T save(T t) {
        return entityRepository.save(t);
    }
}
