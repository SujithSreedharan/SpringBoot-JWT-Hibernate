package org.demo.service;

import java.util.List;

import org.demo.entity.User;


public interface UserBusinessService {
	
	int insertUser(User user);

	List<User> getUsers();

	User getUser(String username);

}
