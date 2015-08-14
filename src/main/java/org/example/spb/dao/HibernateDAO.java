package org.example.spb.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings("unchecked")
public abstract class HibernateDAO<E, K extends Serializable> implements DAO<E, K> {
	@Autowired
	private SessionFactory sf;
	
	protected Class<E> type;
	
	public HibernateDAO() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class<E>) pt.getActualTypeArguments()[0];
	}
	
	@Override
	public K create(E entity) {
		return (K) session().save(entity);
	}

	@Override
	public E findById(K key) {
		return (E) session().load(type, key);
	}

	@Override
	public List<E> findAll() {
		return session().createCriteria(type).list();
	}

	@Override
	public void update(E entity) {
		session().saveOrUpdate(entity);
	}

	@Override
	public void delete(K key) {
		session().delete(findById(key));
	}

	protected Session session() {
		return sf.getCurrentSession();
	}
}