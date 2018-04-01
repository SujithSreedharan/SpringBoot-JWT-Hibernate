package org.demo.dao.impl;

import java.util.List;

import org.demo.common.dao.CommonDao;
import org.demo.dao.UserDao;
import org.demo.entity.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends CommonDao implements UserDao  {

	@Override
	public int insertUser(User student) {
		Session session = getSession();
		session.save(student);
		session.flush();
		return student.getId();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsers() {
		Criteria criteria = getCriteria(User.class);
		//criteria.add(Restrictions.eq(propertyName, value))
		//criteria.setProjection(Projections.count("id"));
		return (List<User>)criteria.list();
	}

	@Override
	public User getUser(String username) {
		Criteria criteria = getCriteria(User.class);
		criteria.add(Restrictions.eq("userName", username));
		return criteria.list().size()!=0 ?(User)criteria.list().get(0) :null;
	}

}
