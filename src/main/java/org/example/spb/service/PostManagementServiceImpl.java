package org.example.spb.service;

import java.util.ArrayList;
import java.util.List;

import org.example.spb.dao.PostDAO;
import org.example.spb.domain.Post;
import org.example.spb.domain.PostDetail;
import org.example.spb.dto.PostDto;
import org.springframework.stereotype.Service;

@Service
public class PostManagementServiceImpl extends ManagementService<PostDto, Integer, PostDAO> implements PostManagementService {

	@Override
	public Integer create(PostDto dto) {
		return dao.create(new Post(dto));
	}

	@Override
	public PostDto getOne(Integer key) {
		return new PostDto(dao.findById(key));
	}

	
	@Override
	public List<PostDto> getAll() {
		List<PostDto> result = new ArrayList<>();
		for (Post post : dao.findAll()) {
			result.add(new PostDto(post));
		}
		return result;
	}
	
	@Override
	public List<PostDto> getRange(Integer start) {
		List<PostDto> result = new ArrayList<>();
		for (Post post : dao.findRange(start)) {
			result.add(new PostDto(post));
		}
		return result;
	}

	@Override
	public Integer update(PostDto dto) {
		return null;
	}

	@Override
	public void delete(Integer key) {
		dao.delete(key);
	}
}
