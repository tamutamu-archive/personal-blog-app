package org.example.spb.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Size;

import org.example.spb.domain.Comment;
import org.example.spb.domain.Post;
import org.hibernate.validator.constraints.NotEmpty;

public class PostDto {	
	@Size(max = 50)
	@NotEmpty
	private String title;
	
	private String body;
	
	private String date;
	
	private List<CommentDto> comments = new ArrayList<>();
	
	public PostDto() {}
	
	//request constructor for /create URL
	public PostDto(String title, String body) {
		this.title = title;
		this.body = body;
	}
	
	//response constructor for /list request
	public PostDto(String title, String preview, String date) {
		this.title = title;
		this.body = preview;
		this.date = date;
	}
	//response constructor for /post/[id] request
	public PostDto(Post post) {
		title = post.getTitle();
		body = post.getPostDetail().toString();
		date = post.getDate();
		for (Comment comment : post.getComments()) {
			comments.add(new CommentDto(comment));
		}
	}

	public String getPreview() {
		if (body.length() > 400) {
			return body.substring(0, 400); 
		}
		return body;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<CommentDto> getComments() {
		return comments;
	}

	public void setComments(List<CommentDto> comments) {
		this.comments = comments;
	}
}