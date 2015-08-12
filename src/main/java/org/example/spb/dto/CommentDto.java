package org.example.spb.dto;

import javax.validation.constraints.Size;

import org.example.spb.domain.Comment;
import org.hibernate.validator.constraints.NotEmpty;

public class CommentDto {
	@Size(max = 4000)
	@NotEmpty
	private String comment;
	
	private String author;
	
	private String date;
	
	public CommentDto() {}
	
	public CommentDto(Comment comment) {
		this.comment = comment.getComment();
		author = comment.getAuthor().getFirstName() + " " + comment.getAuthor().getLastName();
		date = comment.getDate();
	}

	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}