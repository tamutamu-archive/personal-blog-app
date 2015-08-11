package org.example.spb.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Comment extends AbstractEntity {
	@Column
	private String comment;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID") //foreign key Users(id) in the Comments table
	private User author;
	
	@Column
	private Date postDate;
	
	@Column
	private PostDetails post;
	
	public Comment() {}
	

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public PostDetails getPost() {
		return post;
	}

	public void setPost(PostDetails post) {
		this.post = post;
	}
}