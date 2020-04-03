package com.lawencon.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lawencon.app.dao.UserDao;
import com.lawencon.app.dao.impl.hibernate.BaseHibernate;
import com.lawencon.app.model.User;

@Service
@Transactional
public class UserImpl extends BaseHibernate implements UserService {
	
	@Autowired
	@Qualifier("user_repo_hibernate")
	private UserDao userDao;

	@Override
	public Boolean validuser(String user, String pass) throws Exception {
		User users = null;
		try {
			users = userDao.validuser(user, pass); 		
		} catch (Exception e) {
			
		}
		
		if(users != null) {
			return true;
		}else {
			return false;
		}
	}
}
