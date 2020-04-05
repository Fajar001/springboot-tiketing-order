package com.lawencon.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lawencon.app.dao.HargaDao;
import com.lawencon.app.model.Harga;

@Service
@Transactional
public class HargaServiceImpl implements HargaService{
	
	@Autowired
	@Qualifier("harga_repo_jpa")
	private HargaDao hargaDao;
	
	@Autowired
	private UserService userService;
	
	@Override
	public List<Harga> findAll(String user, String pass) throws Exception {
		// TODO Auto-generated method stub
		if(userService.validuser(user, pass) == true) {
			return hargaDao.findAll();
		}
		else {
			return null;
		}	
	}

	@Override
	public String insert(Harga ticket, String user, String pass) throws Exception {
		// TODO Auto-generated method stub
		if(userService.validuser(user, pass) == true) {
			hargaDao.insert(ticket);
		}
		else {
			return "WRONG [USERNAME] OR [PASSWORD] !";
		}
		return "";
	}

	@Override
	public String update(int id, int harga, String user, String pass) throws Exception {
		// TODO Auto-generated method stub
		if(userService.validuser(user, pass) == true) {
			hargaDao.update(id, harga);
		}
		else {
			return "WRONG [USERNAME] OR [PASSWORD] !";
		}
		return "";
	}

	@Override
	public String delete(int id, String user, String pass) throws Exception {
		// TODO Auto-generated method stub
		if(userService.validuser(user, pass) == true) {
			return hargaDao.delete(id);
		}
		else {
			return "WRONG [USERNAME] OR [PASSWORD] !";
		}
	}

	@Override
	public int updatejpa(int id, int harga, String user, String pass) throws Exception {
		// TODO Auto-generated method stub
		if(userService.validuser(user, pass) == true) {
			hargaDao.updatejpa(id, harga);
		}
		return 404;
	}

}
