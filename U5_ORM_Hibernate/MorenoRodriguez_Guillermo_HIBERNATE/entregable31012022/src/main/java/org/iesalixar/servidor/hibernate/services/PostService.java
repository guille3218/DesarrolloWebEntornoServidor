package org.iesalixar.servidor.hibernate.services;

import java.util.List;

import org.iesalixar.servidor.hibernate.model.Post;

public interface PostService {
	
	public void insertNewPost(final Post post);
	
	public void updatePost(final Post post);
	
	public void deletePost(final Post post);
	
	public Post searchById(final Long postId);
	
	public List<Post> getAllPosts();
	
}
