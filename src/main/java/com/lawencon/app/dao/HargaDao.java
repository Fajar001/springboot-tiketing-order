package com.lawencon.app.dao;

import java.util.List;

import com.lawencon.app.model.Harga;

public interface HargaDao {
	abstract List<Harga> findAll() throws Exception;
	abstract Harga insert(Harga ticket) throws Exception;
	abstract Harga update(int id, int harga) throws Exception;
	abstract String delete(int id) throws Exception;
	abstract int updatejpa(int id, int harga) throws Exception;
}
