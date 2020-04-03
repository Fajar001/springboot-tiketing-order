package com.lawencon.app.dao.impl.hibernate;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lawencon.app.dao.UserDao;
import com.lawencon.app.model.User;

@Repository("user_repo_hibernate")
public class UserDaoImpl extends BaseHibernate implements UserDao {

	@Override
	public User validuser(String user, String pass) throws Exception {
		Query q = em.createQuery("from User where username =: userParam and password =: passParam")
				.setParameter("userParam", user)
				.setParameter("passParam", pass);
		return (User) q.getSingleResult();
	}
}
