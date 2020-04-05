package com.lawencon.app.dao.impl.hibernate;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lawencon.app.dao.HargaDao;
import com.lawencon.app.model.Harga;

@Repository("harga_repo_hibernate")
public class HargaDaoImpl extends BaseHibernate implements HargaDao{
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Harga> findAll() throws Exception {
		// TODO Auto-generated method stub
		Query q = em.createQuery("from Harga");
		return q.getResultList();
	}

	@Override
	public Harga insert(Harga ticket) throws Exception {
		// TODO Auto-generated method stub
		em.persist(ticket);
		return ticket;
	}

	@Override
	public Harga update(int id, int harga) throws Exception {
		// TODO Auto-generated method stub
		Query q = em.createQuery("from Harga where idHarga =: id");
		q.setParameter("id", id);
		Harga price = new Harga();
		price = (Harga) q.getSingleResult();
		price.setHarga(harga);
		em.merge(price);
		return price;
	}

	@Override
	public String delete(int id) throws Exception {
		// TODO Auto-generated method stub
		Query q = em.createQuery("from Harga where idHarga =: id");
		q.setParameter("id", id);
		Harga price = new Harga();
		price = (Harga) q.getSingleResult();
		price.setIdHarga(id);
		em.remove(price);
		return "Harga Deleted";
	}

	@Override
	public int updatejpa(int id, int harga) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
