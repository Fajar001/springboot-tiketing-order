package com.lawencon.app.dao;

import com.lawencon.app.model.User;

public interface UserDao {
	abstract User validuser(String user, String pass) throws Exception;
}
