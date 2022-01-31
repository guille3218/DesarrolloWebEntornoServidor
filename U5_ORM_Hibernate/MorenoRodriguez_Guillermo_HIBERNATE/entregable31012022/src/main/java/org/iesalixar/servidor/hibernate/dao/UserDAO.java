package org.iesalixar.servidor.hibernate.dao;

import java.util.List;

import org.iesalixar.servidor.hibernate.model.User;
import org.iesalixar.servidor.hibernate.utils.dao.GenericDAO;

public interface UserDAO extends GenericDAO<User>{

	public List<String> getPostTitlesByUser(Long userId);
	
}
