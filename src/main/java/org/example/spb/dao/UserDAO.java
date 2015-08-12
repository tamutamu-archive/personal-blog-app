package org.example.spb.dao;


import org.example.spb.domain.User;

public interface UserDAO extends DAO<User, Integer> {
	public User getByEmail(String email);
}