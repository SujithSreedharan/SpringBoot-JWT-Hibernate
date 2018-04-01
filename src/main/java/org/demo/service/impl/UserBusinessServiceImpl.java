package org.demo.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.demo.dao.UserDao;
import org.demo.entity.User;
import org.demo.service.UserBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBusinessServiceImpl implements UserBusinessService{
	
	@Autowired
	private UserDao studentDao;
	/*
	 * (non-Javadoc)
	 * @see org.demo.service.UserBusinessService#insertUser(org.demo.entity.User)
	 */
	@Transactional
	@Override
	public int insertUser(User user) {
		return studentDao.insertUser(user);
	}
	@Transactional
	@Override
	public List<User> getUsers() {
		return studentDao.getUsers();
	}
	@Transactional
	@Override
	public User getUser(String username) {
		return studentDao.getUser(username);
	}
	
	

}
