package org.iesalixar.servidor.hibernate.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.iesalixar.servidor.hibernate.model.Post;
import org.iesalixar.servidor.hibernate.model.User;
import org.iesalixar.servidor.hibernate.utils.dao.GenericDAOImpl;

public class UserDAOImpl extends GenericDAOImpl<User> implements UserDAO{
	
	private Session session;

	public UserDAOImpl(Session session) {
		super(session);
		this.session = session;
	}

	@Override 
	public List<String> getPostTitlesByUser(Long userId){
			
		List<String> titles = new ArrayList<String>();
		
		User user = this.searchById(userId);
		
		Set<Post> posts = user.getPosts();
		
		for (Post post : posts) {
			titles.add(post.getTitle());
		}
		
		return titles;
		
	}
}
