package org.example.spb.domain;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class PostDetails extends AbstractEntity {
	@Column
	private String postDetails;
	
	@OneToOne(mappedBy = "postDetails")
	@JoinColumn(name = "POST_DETAILS_ID")
	private Post post;

	public String getPostDetails() {
		return postDetails;
	}

	public void setPostDetails(String postDetails) {
		this.postDetails = postDetails;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
}