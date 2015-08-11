package org.example.spb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "POSTS")
public class Post extends AbstractEntity {
	@Column
	private String title;
	
	@Column
	private String preview;
	
	@OneToOne
	private PostDetails postDetails;
	
	public Post() {}

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

	public PostDetails getPostDetails() {
		return postDetails;
	}

	public void setPostDetails(PostDetails postDetails) {
		this.postDetails = postDetails;
	}
}