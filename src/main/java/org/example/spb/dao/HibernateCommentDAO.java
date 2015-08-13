package org.example.spb.dao;

import org.example.spb.domain.Comment;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateCommentDAO extends HibernateDAO<Comment, Integer>implements CommentDAO {

}