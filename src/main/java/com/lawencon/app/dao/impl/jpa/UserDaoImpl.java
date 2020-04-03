package com.lawencon.app.dao.impl.jpa;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.app.dao.UserDao;
import com.lawencon.app.model.User;

@Repository("user_repo_jpa")
public class UserDaoImpl implements UserDao{
	
//	@Autowired
//	private ParkiranRepo parkirRepo;
	
	@Override
	public User validuser(String user, String pass) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
