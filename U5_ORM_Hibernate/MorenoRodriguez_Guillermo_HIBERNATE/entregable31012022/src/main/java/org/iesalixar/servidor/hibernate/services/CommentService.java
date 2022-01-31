package org.iesalixar.servidor.hibernate.services;

import java.util.List;

import org.iesalixar.servidor.hibernate.model.Comment;

public interface CommentService {

	public void insertNewComment(final Comment comment);
	
	public void updateComment(final Comment comment);
	
	public void deleteComment(final Comment comment);
	
	public Comment searchById(final Long commentId);
	
	public List<Comment> getAllComments();
	
	public List<Comment> searchByWord(final String word);
}
