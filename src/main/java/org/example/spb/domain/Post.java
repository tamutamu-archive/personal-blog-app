package org.example.spb.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.example.spb.dto.PostDto;

@Entity
@Table(name = "POSTS")
public class Post extends AbstractEntity {
	@Column
	private String title;
	
	@Column
	private String preview;
	
	@Column(columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@OneToOne(mappedBy = "post", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	private PostDetail postDetail;
	
	@OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	private Set<Comment> comments = new HashSet<>();
	
	public Post() {}
	
	public Post(PostDto dto) {
		title = dto.getTitle();
		preview = dto.getPreview();
		date = new Date();
		setPostDetail(new PostDetail(dto.getBody()));
	}
	
	public void addComment(Comment comment) {
		comments.add(comment);
		comment.setPost(this);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPreview() {
		return preview;
	}

	public void setPreview(String preview) {
		this.preview = preview;
	}

	public PostDetail getPostDetail() {
		return postDetail;
	}

	public void setPostDetail(PostDetail postDetail) {
		this.postDetail = postDetail;
		postDetail.setPost(this);
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	
	public String getDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy HH:mm");
		return dateFormat.format(date);
	}

	public void setDate(Date date) {
		this.date = date;
	}
}