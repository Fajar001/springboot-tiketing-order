package com.lawencon.app.dao.impl.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.app.dao.TicketDao;
import com.lawencon.app.model.Ticket;

@Repository("ticket_repo_jpa")
public class TicketDaoImpl implements TicketDao{
	
	@Autowired
	private TicketDaoRepo ticketRepo;
	
	@Override
	public List<Ticket> findAll() throws Exception {
		// TODO Auto-generated method stub
		return ticketRepo.findAll();
	}

	@Override
	public Ticket insert(Ticket ticket) throws Exception {
		// TODO Auto-generated method stub
		return ticketRepo.save(ticket);
	}

	@Override
	public Ticket update(int id, int jumPenumpang) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(int id) throws Exception {
		// TODO Auto-generated method stub
		ticketRepo.deleteById(id);
		return "Berhasil Dihapus";
	}

	@Override
	public int updatejpa(int id, int jumPenumpang) throws Exception {
		// TODO Auto-generated method stub
		return ticketRepo.update(id, jumPenumpang);
	}

	@Override
	public List<Ticket> joinAll() throws Exception {
		// TODO Auto-generated method stub
		return ticketRepo.joinAll();
	}
}
