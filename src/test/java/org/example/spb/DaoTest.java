package org.example.spb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

import org.example.spb.dao.PostDAO;
import org.example.spb.dao.PostDetailDAO;
import org.example.spb.domain.Post;
import org.example.spb.domain.PostDetail;
import org.example.spb.domain.User;
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
			PostDto dto = new PostDto("Lorem Ipsum", readFile("src/test/resources/SamplePost.txt"));
			Integer id = postService.create(dto);
			postService.create(dto);
			
			Post post = postDAO.findById(id);
			print(post.getTitle());
			print(post.getPreview());
			print(post.getPostDetail().getPostDetails());
			print(post.getDate());
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