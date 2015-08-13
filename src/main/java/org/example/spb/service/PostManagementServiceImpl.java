package org.example.spb.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.example.spb.dao.CommentDAO;
import org.example.spb.dao.PostDAO;
import org.example.spb.dao.UserDAO;
import org.example.spb.domain.Comment;
import org.example.spb.domain.Post;
import org.example.spb.domain.User;
import org.example.spb.dto.CommentDto;
import org.example.spb.dto.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostManagementServiceImpl extends ManagementService<PostDto, Integer, PostDAO, UserDAO> implements PostManagementService {
	@Autowired
	private CommentDAO commentDao;
	
	@Override
	public Integer create(PostDto dto) {
		return mainDao.create(new Post(dto));
	}

	@Override
	public PostDto getOne(Integer key) {
		return new PostDto(mainDao.findById(key));
	}

	
	@Override
	public List<PostDto> getAll() {
		List<PostDto> result = new ArrayList<>();
		for (Post post : mainDao.findAll()) {
			result.add(new PostDto(post));
		}
		return result;
	}
	
	@Override
	public List<PostDto> getRange(Integer start) {
		List<PostDto> result = new ArrayList<>();
		for (Post post : mainDao.findRange(start)) {
			result.add(new PostDto(post.getId(), post.getTitle(), post.getPreview(), post.getDate()));
		}
		return result;
	}

	@Override
	public Integer update(PostDto dto) {
		Post post = mainDao.findById(dto.getId());
		post.setTitle(dto.getTitle());
		post.setPreview(dto.getPreview());
		post.getPostDetail().setPostDetails(dto.getBody());
		post.setDate(new Date());
		mainDao.update(post);
		return dto.getId();
	}

	@Override
	public void delete(Integer key) {
		mainDao.delete(key);
	}

	@Override
	public void addComment(CommentDto dto, Integer userId, Integer postId) {
		User user = auxDao.findById(userId);
		Post post = mainDao.findById(postId);
		Comment comment = new Comment(dto);
		user.addComment(comment);
		post.addComment(comment);
		mainDao.update(post);
		auxDao.update(user);
	}

	@Override
	public void deleteComment(Integer id) {
		commentDao.delete(id);
	}
}