package com.lawencon.app.service;

import java.util.List;

import com.lawencon.app.model.Ticket;

public interface TicketService {
	abstract List<Ticket> findAll(String user, String pass) throws Exception;
	abstract String insert(Ticket ticket, String user, String pass) throws Exception;
	abstract String update(int id, int jumPenumpang, String user, String pass) throws Exception;
	abstract String delete(int id, String user, String pass) throws Exception;
	abstract int updatejpa(int id, int jumPenumpang, String user, String pass) throws Exception;
	abstract List<Ticket> joinAll(String user, String pass) throws Exception;
}
