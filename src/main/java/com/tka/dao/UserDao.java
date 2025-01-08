package com.tka.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.model.User;

@Repository
public class UserDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public boolean userCheck(User user) {
		System.err.println("inn  userDao"+user);
		Session session= sessionFactory.openSession();
		Criteria criteria= session.createCriteria(User.class);
		criteria.add(Restrictions.eq("userName", user.getUserName()));
		criteria.add(Restrictions.eq("password", user.getPassword()));
		
		List<User>listUsers = criteria.list();
		System.err.println(listUsers);
		if (listUsers != null && listUsers.size()==1) {
			return true;
		}else {
			return false;
		}
		
		
	}

}
