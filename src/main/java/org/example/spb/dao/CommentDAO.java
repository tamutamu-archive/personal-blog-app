package org.example.spb.dao;

import org.example.spb.domain.Comment;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentDAO extends DAO<Comment, Integer> {

}