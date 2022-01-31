package org.iesalixar.servidor.hibernate.dao;

import java.util.List;

import org.iesalixar.servidor.hibernate.model.Comment;
import org.iesalixar.servidor.hibernate.utils.dao.GenericDAO;

public interface CommentDAO extends GenericDAO<Comment>{
	
	public List<Comment> searchByWord(String word);

}
