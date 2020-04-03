package com.lawencon.app.dao.impl.jpa;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.app.dao.ParkiranDao;
import com.lawencon.app.dao.impl.hibernate.BaseHibernate;
import com.lawencon.app.model.Parkiran;

@Repository("parkiran_repo_jpa")
public class ParkiranDaoImpl extends BaseHibernate implements ParkiranDao{
	
	@Autowired
	private ParkiranRepo parkir;

	@Override
	public String insertKendaraan(Parkiran kendaraan, String user, String pass) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String insertCheckoutKendaraan(Parkiran kendaraan, String user, String pass) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Parkiran> viewKendaraanCheckIn() throws Exception {
		// TODO Auto-generated method stub
		return parkir.listCheckIn();
	}

	@Override
	public List<Parkiran> viewKendaraanCheckOut() throws Exception {
		// TODO Auto-generated method stub
		return parkir.listCheckOut();
	}

	@Override
	public Parkiran insert(Parkiran kendaraan) throws Exception {
		// TODO Auto-generated method stub
		return parkir.save(kendaraan);
	}

	@Override
	public Parkiran update(Parkiran kendaraan) throws Exception {
		// TODO Auto-generated method stub
		return parkir.save(kendaraan);
	}
	
	@Override
	public Parkiran validKendaraanCheckIn(Parkiran kendaraan) throws Exception {
		// TODO Auto-generated method stub
		Query q = em.createQuery("from Parkiran where noPlat =: noParam").setParameter("noParam",
				kendaraan.getNoPlat().toLowerCase());
		return (Parkiran) q.getSingleResult();
	}

	@Override
	public Parkiran validKendaraanCheckOut(Parkiran kendaraan) throws Exception {
		// TODO Auto-generated method stub
		Query q = em.createQuery("from Parkiran where noPlat =: noParam").setParameter("noParam",
				kendaraan.getNoPlat().toLowerCase());
		return (Parkiran) q.getSingleResult();
	}
}
