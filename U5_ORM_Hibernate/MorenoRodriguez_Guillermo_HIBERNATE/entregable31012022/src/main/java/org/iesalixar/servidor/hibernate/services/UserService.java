package org.iesalixar.servidor.hibernate.services;

import java.util.List;

import org.iesalixar.servidor.hibernate.model.User;

public interface UserService {

	public void insertNewUser(final User user);
	
	public void updateUser(final User user);
	
	public void deleteUser(final User user);
	
	public User searchById(final Long userId);
	
	public List<User> getAllUsers();
	
	public List<String> getPostTitlesByUser(final Long userId);
}
