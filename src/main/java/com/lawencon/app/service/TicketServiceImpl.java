package com.lawencon.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lawencon.app.dao.TicketDao;
import com.lawencon.app.model.Ticket;

@Service
@Transactional
public class TicketServiceImpl implements TicketService{
	
	@Autowired
	@Qualifier("ticket_repo_hibernate")
	private TicketDao ticketDao;
	
	@Autowired
	private UserService userService;
	
	@Override
	public List<Ticket> findAll(String user, String pass) throws Exception {
		// TODO Auto-generated method stub
		if (userService.validuser(user, pass) == true) {
			return ticketDao.findAll();
		}
		else {
			return null;
		}	
	}

	@Override
	public String insert(Ticket ticket, String user, String pass) throws Exception {
		// TODO Auto-generated method stub
		if (userService.validuser(user, pass) == true) {
			ticketDao.insert(ticket);
		}
		else {
			return "WRONG [USERNAME] OR [PASSWORD] !";
		}
		return "";		
	}

	@Override
	public String update(int id, int jumPenumpang, String user, String pass) throws Exception {
		// TODO Auto-generated method stub
		if (userService.validuser(user, pass) == true) {
			ticketDao.update(id, jumPenumpang);
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
			ticketDao.delete(id);
		}
		else {
			return "WRONG [USERNAME] OR [PASSWORD] !";
		}
		return "";
	}

	@Override
	public int updatejpa(int id, int jumPenumpang, String user, String pass) throws Exception {
		// TODO Auto-generated method stub
		if (userService.validuser(user, pass) == true) {
			ticketDao.updatejpa(id, jumPenumpang);
		}
		return 404;
	}

	@Override
	public List<Ticket> joinAll(String user, String pass) throws Exception {
		// TODO Auto-generated method stub
		if (userService.validuser(user, pass) == true) {
			return ticketDao.joinAll();
		}
		else {
			return null;
		}	
	}
}
