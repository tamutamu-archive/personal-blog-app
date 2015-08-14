package org.example.spb.dao;

import java.util.List;

import org.example.spb.domain.User;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateUserDAO extends HibernateDAO<User, Integer>implements UserDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getByEmail(String email) {
		Query query = session().createSQLQuery("SELECT * FROM Users WHERE email = :email").
				addEntity(type).
					setString("email", email);
		return query.list();
	}
}