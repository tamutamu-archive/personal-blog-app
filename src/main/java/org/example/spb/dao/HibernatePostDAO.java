package org.example.spb.dao;

import java.util.List;

import org.example.spb.domain.Post;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unchecked")
@Repository
public class HibernatePostDAO extends HibernateDAO<Post, Integer>implements PostDAO {

	@Override
	public List<Post> findRange(Integer offset) {
		Query query = session().
				createSQLQuery("SELECT * FROM Posts  ORDER BY DATE DESC LIMIT ?,?").
					addEntity(type);
		query.setParameter(0, offset);
		query.setParameter(1, 20);
		return query.list();
	}
}