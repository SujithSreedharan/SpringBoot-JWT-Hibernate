package org.demo.dao;

import java.util.List;

import org.demo.entity.User;

public interface UserDao {

	int insertUser(User student);

	List<User> getUsers();

	User getUser(String username);

}
