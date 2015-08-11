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

	@OneToOne(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private PostDetail postDetail;
	
	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Comment> comments = new HashSet<>();
	
	public Post() {}
	
	public Post(String title, String preview, PostDetail postDetail) {
		this.title = title;
		this.preview = preview;
		this.date = new Date();
		setPostDetail(postDetail);
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