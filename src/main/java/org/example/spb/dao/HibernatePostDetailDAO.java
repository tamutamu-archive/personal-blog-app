package org.example.spb.dao;

import org.example.spb.domain.PostDetail;
import org.springframework.stereotype.Repository;

@Repository
public class HibernatePostDetailDAO extends HibernateDAO<PostDetail, Integer>implements PostDetailDAO {
}