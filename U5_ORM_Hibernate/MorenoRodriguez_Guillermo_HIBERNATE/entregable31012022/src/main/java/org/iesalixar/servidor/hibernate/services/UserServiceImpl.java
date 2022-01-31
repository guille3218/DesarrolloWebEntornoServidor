package org.iesalixar.servidor.hibernate.services;

import java.util.List;

import org.hibernate.Session;
import org.iesalixar.servidor.hibernate.dao.UserDAO;
import org.iesalixar.servidor.hibernate.dao.UserDAOImpl;
import org.iesalixar.servidor.hibernate.model.User;

public class UserServiceImpl implements UserService{

	private UserDAO userDAO;
	
	public UserServiceImpl(final Session session) {
		this.userDAO = new UserDAOImpl(session);
	}
	
	@Override
	public void insertNewUser(final User user) {
		// Compruebo que no es nulo y que aún no existe
		// es decir no tiene ID
		
		if(user != null && user.getId() == null) {
			
			//Inserto el nuevo usuario
			userDAO.insert(user);
		}
	}
	
	@Override
	public void updateUser(final User user) {
		// Compruebo que no es nulo y que ya existe (tiene ID)
		if(user != null && user.getId()!= null) {
			// Actualizo el usuario
			userDAO.update(user);
		}
		
	}
	
	@Override
	public void deleteUser(final User user) {
		
		if(user != null && user.getId()!=null) {
			userDAO.delete(user);
		}
		
	}
	
	@Override
	public User searchById(final Long userId) {
		
		User user = null;
		
		if (userId != null) {
			user = userDAO.searchById(userId);
		}
		
		return user;
	}
	
	@Override
	public List<User> getAllUsers() {
		List<User> users = null;
		
		users = userDAO.searchAll();
		
		return users;
	}
	
	@Override
	public List<String> getPostTitlesByUser(final Long userId) {
		List<String> titles = null;
		
		if(userId != null) {
			titles = userDAO.getPostTitlesByUser(userId);
		}
		
		return titles;
	}
}
