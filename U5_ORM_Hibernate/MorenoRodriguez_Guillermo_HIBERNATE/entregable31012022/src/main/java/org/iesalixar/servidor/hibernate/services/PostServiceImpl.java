package org.iesalixar.servidor.hibernate.services;

import java.util.List;

import org.hibernate.Session;
import org.iesalixar.servidor.hibernate.dao.PostDAO;
import org.iesalixar.servidor.hibernate.dao.PostDAOImpl;
import org.iesalixar.servidor.hibernate.model.Post;
import org.iesalixar.servidor.hibernate.model.User;

public class PostServiceImpl implements PostService{

	private PostDAO postDAO;
	
	public PostServiceImpl(final Session session) {
	this.postDAO = new PostDAOImpl(session);
	}
	
	@Override
	public void insertNewPost(final Post post) {
		
		if(post != null && post.getId() == null) {

			postDAO.insert(post);
		}
		
	}
	
	@Override
	public void updatePost(final Post post) {
		
		if(post != null && post.getId()!= null) {
		
			postDAO.update(post);
		}
		
	}
	
	@Override
	public void deletePost(final Post post) {
		
		if(post != null && post.getId()!=null) {
			postDAO.delete(post);
		}
		
	}
	
	@Override
	public Post searchById(final Long postId) {
		Post post = null;
		
		if (postId != null) {
			post = postDAO.searchById(postId);
		}
		
		return post;
	}
	
	@Override
	public List<Post> getAllPosts() {
		
		List<Post> posts = null;
		
		posts = postDAO.searchAll();
		
		return posts;
	}
}
