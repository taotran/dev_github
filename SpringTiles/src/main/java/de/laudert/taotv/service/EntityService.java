package de.laudert.taotv.service;

import de.laudert.taotv.exception.ItemNotFoundException;

import java.util.List;

/**
 * User: tvt
 * Date: 9/26/14
 * Time: 9:53 AM
 */
public interface EntityService<T> {

    public T findOne(Long id);

    public List<T> findAll();

    public void delete(Long id) throws ItemNotFoundException;

    public T save(T t);

    public long count();
}
