package com.lawencon.app.dao.impl.hibernate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lawencon.app.dao.ParkiranDao;
import com.lawencon.app.model.Parkiran;

@Repository("parkiran_repo_hibernate")
public class ParkiranDaoImpl extends BaseHibernate implements ParkiranDao{
	
	@Override
	public String insertKendaraan(Parkiran kendaraan, String user, String pass) throws Exception {
		em.persist(kendaraan);
		return "Ok";
	}

	@Override
	public Parkiran validKendaraanCheckIn(Parkiran kendaraan) throws Exception {
		Query q = em.createQuery("from Parkiran where noPlat =: noParam").setParameter("noParam",
				kendaraan.getNoPlat().toLowerCase());
		return (Parkiran) q.getSingleResult();
	}

	@Override
	public Parkiran validKendaraanCheckOut(Parkiran kendaraan) throws Exception {
		Query q = em.createQuery("from Parkiran where noPlat =: noParam and tanggalKeluar is null")
				.setParameter("noParam", kendaraan.getNoPlat().toLowerCase());
		return (Parkiran) q.getSingleResult();
	}

	@Override
	public String insertCheckoutKendaraan(Parkiran kendaraan, String user, String pass) throws Exception {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		Query q = em.createQuery("from Parkiran where noPlat =: noParam and tanggalKeluar is null")
				.setParameter("noParam", kendaraan.getNoPlat().toLowerCase());
		try {
			kendaraan = (Parkiran) q.getSingleResult();
			kendaraan.setTanggalKeluar(String.valueOf(dateFormat.format(date)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		em.merge(kendaraan);
		return "Berhasil";
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Parkiran> viewKendaraanCheckIn() throws Exception {
		Query q = em.createQuery("from Parkiran where tanggalKeluar is null");
		return q.getResultList();		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Parkiran> viewKendaraanCheckOut() throws Exception {
		Query q = em.createQuery("from Parkiran where tanggalKeluar is not null");
		return q.getResultList();
	}

	@Override
	public Parkiran insert(Parkiran kendaraan) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Parkiran update(Parkiran kendaraan) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
