package com.Eseurveys.service;

import java.util.List;

import com.Eseurveys.model.entity.User;

public interface UserService {
	User getUserById(Long id);

	User addUser(User user);

	User updateUser(User user, Long id);

	List<User> getAll();

	void deletUser(Long id);
	
	User getByPseudo(String pseudo);

}