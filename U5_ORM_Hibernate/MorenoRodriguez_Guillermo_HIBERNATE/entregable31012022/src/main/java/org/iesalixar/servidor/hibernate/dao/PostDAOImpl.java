package org.iesalixar.servidor.hibernate.dao;

import org.hibernate.Session;
import org.iesalixar.servidor.hibernate.model.Post;
import org.iesalixar.servidor.hibernate.utils.dao.GenericDAO;
import org.iesalixar.servidor.hibernate.utils.dao.GenericDAOImpl;

public class PostDAOImpl extends GenericDAOImpl<Post> implements PostDAO{
	
	private Session session;

	public PostDAOImpl(Session session) {
		super(session);
		this.session = session;
	}


}
