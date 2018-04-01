package org.demo.common.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommonDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	protected Criteria getCriteria(Class<?> classz) {
		return getSession().createCriteria(classz);
	}

}
