package com.subastas.domain.dao;
import java.util.List;
import java.util.Map;

public interface GenericDAO <T, PK> {
    T create(T entity);
    T findById(Class<T> entityClass, PK id);
    List<T> findAll(Class<T> entityClass);
    List<T> findByNamedQuery(String queryName, Object... params);
    List<T> findByNamedQueryAndNamedParams(String queryName, Map<String, ?> params);
    int countAll(Class<T> entityClass);
    T update(T entity);
    void delete(T entity);
}