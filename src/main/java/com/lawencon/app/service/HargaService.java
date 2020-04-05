package com.lawencon.app.service;

import java.util.List;

import com.lawencon.app.model.Harga;

public interface HargaService {
	abstract List<Harga> findAll(String user, String pass) throws Exception;
	abstract String insert(Harga ticket, String user, String pass) throws Exception;
	abstract String update(int id, int harga, String user, String pass) throws Exception;
	abstract String delete(int id, String user, String pass) throws Exception;
	abstract int updatejpa(int id, int harga, String user, String pass) throws Exception;
}
