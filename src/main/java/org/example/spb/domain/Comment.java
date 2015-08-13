package org.example.spb.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.example.spb.dto.CommentDto;

@Entity
@Table(name = "COMMENTS")
public class Comment extends AbstractEntity {
	@Column
	private String comment;
	
	@Column(columnDefinition = "DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID") //foreign key Users(id) in the Comments table
	private User author;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POST_ID") //foreign key POST_DETAILS(id) in the Comments table
	private Post post;
	
	public Comment() {}
	
	public Comment(CommentDto dto) {
		comment = dto.getComment();
		date = new Date();
	}
	

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

	public String getDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy HH:mm");
		return dateFormat.format(date);
	}

	public void setDate(Date postDate) {
		this.date = postDate;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
}