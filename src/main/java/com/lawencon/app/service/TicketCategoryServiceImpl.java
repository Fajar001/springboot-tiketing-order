package com.lawencon.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lawencon.app.dao.TicketCategoryDao;
import com.lawencon.app.model.TicketCategory;

@Service
@Transactional
public class TicketCategoryServiceImpl implements TicketCategoryService{
	
	@Autowired
	@Qualifier("category_repo_jpa")
	private TicketCategoryDao ticketDao;
	
	@Autowired
	private UserService userService;
	
	@Override
	public List<TicketCategory> findAll(String user, String pass) throws Exception {
		// TODO Auto-generated method stub
		if (userService.validuser(user, pass) == true) {
			return ticketDao.findAll();
		}
		else {
			return null;		
		}	
	}

	@Override
	public String insert(TicketCategory category, String user, String pass) throws Exception {
		// TODO Auto-generated method stub
		if (userService.validuser(user, pass) == true) {
			ticketDao.insert(category);
		}
		else {
			return "WRONG [USERNAME] OR [PASSWORD] !";
		}
		return "";
	}

	@Override
	public String update(int id, String jenis, String user, String pass) throws Exception {
		// TODO Auto-generated method stub
		if (userService.validuser(user, pass) == true) {
			ticketDao.update(id, jenis);
		}
		else {
			return "WRONG [USERNAME] OR [PASSWORD] !";
		}
		return "";
	}

	@Override
	public String delete(int id, String user, String pass) throws Exception {
		// TODO Auto-generated method stub
		if (userService.validuser(user, pass) == true) {
			return ticketDao.delete(id);
		}
		else {
			return "WRONG [USERNAME] OR [PASSWORD] !";
		}
	}

	@Override
	public int updatejpa(int id, String jenis, String user, String pass) throws Exception {
		// TODO Auto-generated method stub
		if (userService.validuser(user, pass) == true) {
			ticketDao.updatejpa(id, jenis);
		}
		return 0;
	}

}
