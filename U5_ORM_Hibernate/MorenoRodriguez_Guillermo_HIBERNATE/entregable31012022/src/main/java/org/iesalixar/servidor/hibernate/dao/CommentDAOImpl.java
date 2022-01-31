package org.iesalixar.servidor.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.iesalixar.servidor.hibernate.model.Comment;
import org.iesalixar.servidor.hibernate.utils.dao.GenericDAOImpl;

public class CommentDAOImpl extends GenericDAOImpl<Comment> implements CommentDAO{
	
	private Session session;
	
	public CommentDAOImpl(Session session) {
		super(session);
		this.session = session;
	}
	
	@Override
	public List<Comment> searchByWord(String word){
		// Compruebo que la conexión está actica
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}
		
		//modifico la variable para que a la hora de hacer 
		//la consulta encuentre comentarios que contenga la palabra
		
		word= "%"+word+"%";
		
		
		List<Comment> commentList = session.createQuery("FROM comments WHERE content LIKE ':word'")
				.setParameter("word", word)
				.list();
		
		return commentList;
	}
}
