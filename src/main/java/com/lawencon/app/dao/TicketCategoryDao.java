package com.lawencon.app.dao;

import java.util.List;

import com.lawencon.app.model.TicketCategory;

public interface TicketCategoryDao {
	abstract List<TicketCategory> findAll() throws Exception;
	abstract TicketCategory insert(TicketCategory category) throws Exception;
	abstract TicketCategory update(int id, String jenis) throws Exception;
	abstract String delete(int id) throws Exception;
	abstract int  updatejpa(int id, String jenis) throws Exception;
}
