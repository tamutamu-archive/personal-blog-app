package org.example.spb.service;

import java.util.List;

import org.example.spb.domain.Post;
import org.example.spb.domain.PostDetail;
import org.example.spb.dto.PostDto;
import org.springframework.stereotype.Service;

@Service
public class PostManagementServiceImpl extends ManagementService<PostDto, Integer, Post> implements PostManagementService {

	@Override
	public Integer create(PostDto dto) {
		Post post = new Post(dto.getTitle(), dto.getPreview(), new PostDetail(dto.getBody()));
		return dao.create(post);
	}

	@Override
	public PostDto getOne(Integer key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer update(PostDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer key) {
		// TODO Auto-generated method stub

	}

}
