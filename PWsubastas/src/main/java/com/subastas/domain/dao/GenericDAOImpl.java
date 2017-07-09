package com.subastas.domain.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import com.subastas.domain.db.EntityManagerUtil;
 
public abstract class GenericDAOImpl<T extends Serializable, PK> implements GenericDAO<T, PK> {
 
	protected EntityManager entityManager = EntityManagerUtil.getEntityManager();
 
    @Override
    public T create(T entity) {
        try {
		      entityManager.getTransaction().begin();
		      entity  = this.entityManager.merge(entity);
		      entityManager.getTransaction().commit();
	    } catch (Exception e) {
	      entityManager.getTransaction().rollback();
	    }
        return entity;
    }
 
    @Override
    public T findById(Class<T> entityClass, PK id) {
        return this.entityManager.find(entityClass, id);
    }
 
    @Override
    public List<T> findAll(Class<T> entityClass) {
        return findByCriteria(entityClass);
    }
 
    @SuppressWarnings("unchecked")
	@Override
    public List<T> findByNamedQuery(final String name, Object... params) {
        javax.persistence.Query query = entityManager.createNamedQuery(
                name);
 
        for (int i = 0; i < params.length; i++) {
            query.setParameter(i + 1, params[i]);
        }
 
        return (List<T>) query.getResultList();
    }
 
    @SuppressWarnings("unchecked")
	@Override
    public List<T> findByNamedQueryAndNamedParams(final String name, final Map<String, ?> params) {
        javax.persistence.Query query = entityManager.createNamedQuery(
                name);
 
        for (final Map.Entry<String, ?> param : params.entrySet()) {
            query.setParameter(param.getKey(), param.getValue());
        }
 
        return (List<T>) query.getResultList();
    }
 
    @Override
    public int countAll(Class<T> entityClass) {
        return countByCriteria(entityClass);
    }
 
    @Override
    public T update(T entity) {
        try {
		      entityManager.getTransaction().begin();
		      entity = this.entityManager.merge(entity);
		      entityManager.getTransaction().commit();
	    } catch (Exception e) {
	      entityManager.getTransaction().rollback();
	    }
        return entity;
    }
 
    @Override
    public void delete(T entity) {
        try {
		      entityManager.getTransaction().begin();
		      this.entityManager.remove(entity);
		      entityManager.getTransaction().commit();
	    } catch (Exception e) {
	      entityManager.getTransaction().rollback();
	    }
    }
 
 
    protected List<T> findByCriteria(Class<T> entityClass, final Criterion... criterion) {
        return findByCriteria(entityClass, -1, -1, null, criterion);
    }
 
    @SuppressWarnings("unchecked")
	protected List<T> findByCriteria(Class<T> entityClass, final int firstResult,
            final int maxResults, final Order order, final Criterion... criterion) {
        Session session = (Session) entityManager.getDelegate();
        Criteria crit = session.createCriteria(entityClass);
 
        for (final Criterion c : criterion) {
        	if (c != null) {
        		crit.add(c);
        	}
        }
 
        if( order != null ) {
            crit.addOrder(order);
        }
 
        if (firstResult > 0) {
            crit.setFirstResult(firstResult);
        }
 
        if (maxResults > 0) {
            crit.setMaxResults(maxResults);
        }
 
        return crit.list();
    }
 
    protected int countByCriteria(Class<T> entityClass, Criterion... criterion) {
        Session session = (Session) entityManager.getDelegate();
        Criteria crit = session.createCriteria(entityClass);
        crit.setProjection(Projections.rowCount());
 
        for (final Criterion c : criterion) {
        	if (c != null) {
        		crit.add(c);
        	}
        }
 
        return ((Long) crit.list().get(0)).intValue();
    }
}