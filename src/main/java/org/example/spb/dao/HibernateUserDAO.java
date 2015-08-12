package org.example.spb.dao;

import org.example.spb.domain.User;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateUserDAO extends HibernateDAO<User, Integer>implements UserDAO {

	@Override
	public User getByEmail(String email) {
		Query query = session().createSQLQuery("SELECT * FROM Users WHERE email = :email").
				addEntity(type).
					setString("email", email);
		return (User) query.list().get(0);
	}
}