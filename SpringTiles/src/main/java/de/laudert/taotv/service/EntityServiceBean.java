package de.laudert.taotv.service;

import java.util.List;

/**
 * User: tvt
 * Date: 9/26/14
 * Time: 10:05 AM
 */
public class EntityServiceBean<T> implements EntityService<T> {

    @Override
    public T findOne(Long id) {
        return null;
    }

    @Override
    public List<T> findAll() {
        System.out.println("Inside findAll()");
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public T save(T t) {
        return null;
    }
}
