package com.lawencon.app.dao.impl.hibernate;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lawencon.app.dao.TicketCategoryDao;
import com.lawencon.app.model.TicketCategory;

@Repository("category_repo_hibernate")
public class TicketCategoryDaoImpl extends BaseHibernate implements TicketCategoryDao{
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TicketCategory> findAll() throws Exception {
		// TODO Auto-generated method stub
		Query q = em.createQuery("from TicketCategory");
		return q.getResultList();
	}

	@Override
	public TicketCategory insert(TicketCategory category) throws Exception {
		// TODO Auto-generated method stub
		em.persist(category);
		return category;
	}

	@Override
	public TicketCategory update(int id, String jenis) throws Exception {
		// TODO Auto-generated method stub
		Query q = em.createQuery("from TicketCategory where catId =: id");
		q.setParameter("id", id);
		TicketCategory category = new TicketCategory();
		category = (TicketCategory) q.getSingleResult();
		category.setJenisTicket(jenis);
		em.merge(category);
		return category;
	}

	@Override
	public String delete(int id) throws Exception {
		// TODO Auto-generated method stub
		Query q = em.createQuery("from TicketCategory where catId =: id");
		q.setParameter("id", id);
		TicketCategory category = new TicketCategory();
		category = (TicketCategory) q.getSingleResult();
		category.setCatId(id);
		em.remove(category);
		return "Category dihapus";
	}

	@Override
	public int updatejpa(int id, String jenis) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
