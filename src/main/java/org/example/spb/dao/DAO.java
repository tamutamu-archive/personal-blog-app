package org.example.spb.dao;

import java.util.List;

public interface DAO<E, K> {
	public K create(E entity);
	public E findById(K key);
	public List<E> findAll();
	public void update(E entity);
	public void delete(K key);
}