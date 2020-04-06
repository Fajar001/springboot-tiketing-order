package com.lawencon.app.dao;

import java.util.List;

import com.lawencon.app.model.Ticket;

public interface TicketDao {
	abstract List<Ticket> findAll() throws Exception;
	abstract Ticket insert(Ticket ticket) throws Exception;
	abstract Ticket update(int id, int jumPenumpang) throws Exception;
	abstract String delete(int id) throws Exception;
	abstract int  updatejpa(int id, int jumPenumpang) throws Exception;
	abstract List<Ticket> joinAll() throws Exception;
	abstract List<Ticket> trx() throws Exception;
}
