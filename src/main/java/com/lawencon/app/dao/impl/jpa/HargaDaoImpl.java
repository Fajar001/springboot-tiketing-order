package com.lawencon.app.dao.impl.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.app.dao.HargaDao;
import com.lawencon.app.model.Harga;

@Repository("harga_repo_jpa")
public class HargaDaoImpl implements HargaDao{
	
	@Autowired
	private HargaRepo hargaRepo;
	
	@Override
	public List<Harga> findAll() throws Exception {
		// TODO Auto-generated method stub
		return hargaRepo.findAll();
	}

	@Override
	public Harga insert(Harga ticket) throws Exception {
		// TODO Auto-generated method stub
		return hargaRepo.save(ticket);
	}

	@Override
	public Harga update(int id, int harga) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(int id) throws Exception {
		// TODO Auto-generated method stub
		hargaRepo.deleteById(id);
		return "Harga Deleted";
	}

	@Override
	public int updatejpa(int id, int harga) throws Exception {
		// TODO Auto-generated method stub
		return hargaRepo.update(id, harga);
	}

}
