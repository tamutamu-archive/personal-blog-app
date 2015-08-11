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
import org.example.spb.dto.PostDto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DaoTest extends AbstractDaoTest{
	@Autowired
	private PostDAO postDAO;
	
	@Autowired
	private PostDetailDAO postDetailDAO;
	
	@Test
	public void postDaoTest() {		
		try {
			PostDto dto = new PostDto("Lorem Ipsum", readFile("src/test/resources/SamplePost.txt"));
			Integer id = createPost(dto);
			Post post = postDAO.findById(id);
			
			print(post.getTitle());
			print(post.getPreview());
			print(post.getPostDetail().getPostDetails());
			print(post.getDate());
		} catch (IOException e) {
			print(e.getMessage());
		}
	}
	
	public Integer createPost(PostDto dto) {
		//validate data
		//TODO
		//write generic validator 
		//then extend it to build specific validators for each entity type
		Post post = new Post(dto.getTitle(), dto.getPreview(), new PostDetail(dto.getBody()));
		return postDAO.create(post);
	}
	
	private String readFile(String fileName) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			
			while (line != null) {
				sb.append(line);
				sb.append("\n");
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