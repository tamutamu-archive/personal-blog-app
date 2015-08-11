package org.example.spb.dao;


import org.example.spb.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateUserDAO extends HibernateDAO<User, Integer>implements UserDAO {
	
}