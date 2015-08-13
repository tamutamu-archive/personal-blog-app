package org.example.spb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.example.spb.dao.PostDAO;
import org.example.spb.dao.PostDetailDAO;
import org.example.spb.domain.Post;
import org.example.spb.domain.PostDetail;
import org.example.spb.domain.User;
import org.example.spb.dto.CommentDto;
import org.example.spb.dto.PostDto;
import org.example.spb.service.PostManagementService;
import org.example.spb.service.PostManagementServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class DaoTest extends AbstractDaoTest{
	@Autowired
	private PostDAO postDAO;
	
	@Autowired
	private PostDetailDAO postDetailDAO;
	
	@Autowired
	private PostManagementService postService;
	
	@Test
	public void postDaoTest() {		
		try {
			//create post
			PostDto dto = new PostDto("Lorem Ipsum", readFile("src/test/resources/SamplePost.txt"));
			Integer id = postService.create(dto);
			
			//read post id
			dto = postService.getOne(id);
			print(dto.getId().toString());
			print(dto.getTitle());
			print(dto.getPreview());
			print(dto.getBody());
			print(dto.getDate());
			
			dto = new PostDto("MySQL", readFile("src/test/resources/SamplePost2.txt"));
			Integer id2 = postService.create(dto);
			
			//read post id2
			dto = postService.getOne(id2);
			print(dto.getId().toString());
			print(dto.getTitle());
			print(dto.getPreview());
			print(dto.getBody());
			print(dto.getDate());
			
			//list posts
			List<PostDto> range = postService.getRange(0);
			for (PostDto dto2 : range) {
				print(dto2.getId().toString());
				print(dto2.getTitle());
				print(dto2.getPreview());
				print(dto2.getDate());
			}
			
			//read post id2
			dto = postService.getOne(id2);
			dto.setTitle("Жесть");
			dto.setBody(readFile("src/test/resources/SamplePost3.txt"));
			postService.update(dto);
			
			range = postService.getRange(0);
			for (PostDto dto2 : range) {
				print(dto2.getId().toString());
				print(dto2.getTitle());
				print(dto2.getPreview());
				print(dto2.getDate());
			}
			
			//create a comment
			CommentDto commentDto = new CommentDto();
			commentDto.setComment(readFile("src/test/resources/SampleComment.txt"));
			//postService.addComment(commentDto, userId, id2);
			
		} catch (IOException e) {
			print(e.getMessage());
		}
	}
	
	private String readFile(String fileName) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			
			while (line != null) {
				sb.append(line);
				line = br.readLine();
			}
			return sb.toString();
		} finally {
			br.close();
		}
	}
	
	private void print(String s) {
		System.out.println(s);
	}
}