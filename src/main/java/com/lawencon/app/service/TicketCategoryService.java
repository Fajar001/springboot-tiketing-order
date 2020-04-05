package com.lawencon.app.service;

import java.util.List;

import com.lawencon.app.model.TicketCategory;

public interface TicketCategoryService {
	abstract List<TicketCategory> findAll(String user, String pass) throws Exception;
	abstract String insert(TicketCategory category, String user, String pass) throws Exception;
	abstract String update(int id, String jenis, String user, String pass) throws Exception;
	abstract String delete(int id, String user, String pass) throws Exception;
	abstract int updatejpa(int id, String jenis, String user, String pass) throws Exception;
}
