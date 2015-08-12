package org.example.spb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Post_Details")
public class PostDetail extends AbstractEntity {
	@Column(name = "post_details")
	private String postDetail;
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Post post;
	
	public PostDetail() {}
	
	public PostDetail(String postDetail) {
		this.postDetail = postDetail;
	}

	public String getPostDetails() {
		return postDetail;
	}

	public void setPostDetails(String postDetails) {
		this.postDetail = postDetails;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
	
	@Override
	public String toString() {
		return getPostDetails();
	}
}