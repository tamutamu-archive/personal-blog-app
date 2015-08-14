package org.example.spb.dao;


import java.util.List;

import org.example.spb.domain.User;

public interface UserDAO extends DAO<User, Integer> {
	public List<User> getByEmail(String email);
}