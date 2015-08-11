package org.example.spb.dao;

import java.util.List;

import org.example.spb.domain.Post;

public interface PostDAO extends DAO<Post, Integer> {
	public List<Post> findRange(Integer offset);
}