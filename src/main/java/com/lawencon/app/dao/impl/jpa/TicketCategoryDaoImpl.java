package com.lawencon.app.dao.impl.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.app.dao.TicketCategoryDao;
import com.lawencon.app.model.TicketCategory;

@Repository("category_repo_jpa")
public class TicketCategoryDaoImpl implements TicketCategoryDao{
	
	@Autowired
	private TicketCategoryRepo categoryRepo;
	
	@Override
	public List<TicketCategory> findAll() throws Exception {
		// TODO Auto-generated method stub
		return categoryRepo.findAll();
	}

	@Override
	public TicketCategory insert(TicketCategory category) throws Exception {
		// TODO Auto-generated method stub
		return categoryRepo.save(category);
	}

	@Override
	public TicketCategory update(int id, String jenis) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(int id) throws Exception {
		// TODO Auto-generated method stub
		categoryRepo.deleteById(id);
		return "Berhasil Dihapus";
	}

	@Override
	public int updatejpa(int id, String jenis) throws Exception {
		// TODO Auto-generated method stub
		return categoryRepo.update(id, jenis);
	}

}
