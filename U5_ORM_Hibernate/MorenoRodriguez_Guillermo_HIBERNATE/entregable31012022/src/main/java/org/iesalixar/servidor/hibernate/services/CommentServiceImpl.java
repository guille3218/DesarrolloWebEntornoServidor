package org.iesalixar.servidor.hibernate.services;

import java.util.List;

import org.hibernate.Session;
import org.iesalixar.servidor.hibernate.dao.CommentDAO;
import org.iesalixar.servidor.hibernate.dao.CommentDAOImpl;
import org.iesalixar.servidor.hibernate.model.Comment;
import org.iesalixar.servidor.hibernate.model.Post;

public class CommentServiceImpl implements CommentService{

	private CommentDAO commentDAO;
	
	public CommentServiceImpl(final Session session) {
		this.commentDAO = new CommentDAOImpl(session);
	}
	
	@Override
	public void insertNewComment(final Comment comment) {
		if(comment != null && comment.getId() == null) {

			commentDAO.insert(comment);
		}
		
	}
	
	@Override
	public void updateComment(final Comment comment) {
		
		if(comment != null && comment.getId()!= null) {
			
			commentDAO.update(comment);
		}
		
	}
	
	@Override
	public void deleteComment(final Comment comment) {
		
		
		if(comment != null && comment.getId()!=null) {
			commentDAO.delete(comment);
		}
		
	}
	
	@Override
	public Comment searchById(final Long commentId) {
		
		Comment comment = null;
		
		if (commentId != null) {
			comment = commentDAO.searchById(commentId);
		}
		
		return comment;
	}
	
	@Override
	public List<Comment> getAllComments() {
		
		List<Comment> comments = null;
		
		comments = commentDAO.searchAll();
		
		return comments;
	}
	
	@Override
	public List<Comment> searchByWord(final String word) {
		List<Comment> comments = null;
		
		if(word!=null) {
			comments = commentDAO.searchByWord(word);
		}
		
		return comments;
	}
	
}
