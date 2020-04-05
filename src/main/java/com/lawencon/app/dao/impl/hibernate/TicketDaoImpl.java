package com.lawencon.app.dao.impl.hibernate;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lawencon.app.dao.TicketDao;
import com.lawencon.app.model.Ticket;

@Repository("ticket_repo_hibernate")
public class TicketDaoImpl extends BaseHibernate implements TicketDao{
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Ticket> findAll() throws Exception {
		// TODO Auto-generated method stub
		Query q = em.createQuery("from Ticket");
		return q.getResultList();
	}

	@Override
	public Ticket insert(Ticket ticket) throws Exception {
		// TODO Auto-generated method stub
		em.persist(ticket);
		return ticket;
	}

	@Override
	public Ticket update(int id, int jumPenumpang) throws Exception {
		// TODO Auto-generated method stub
		Query q = em.createQuery("from Ticket where idTicket =: id");
		q.setParameter("id", id);
		Ticket tiket = new Ticket();
		tiket = (Ticket) q.getSingleResult();
		tiket.setJumlahPenumpang(jumPenumpang);
		em.merge(tiket);
		return tiket;
	}

	@Override
	public String delete(int id) throws Exception {
		// TODO Auto-generated method stub
		Query q = em.createQuery("from Ticket where idTicket =: id");
		q.setParameter("id", id);
		Ticket tiket = new Ticket();
		tiket = (Ticket) q.getSingleResult();
		tiket.setIdTicket(id);
		em.remove(tiket);
		return"Ticket Deleted";
	}

	@Override
	public int updatejpa(int id, int jumPenumpang) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Ticket> joinAll() throws Exception {
		// TODO Auto-generated method stub
		Query q = em.createNativeQuery("select \r\n" + 
				"	t.nama_penumpang, t.jumlah_penumpang, t.kota_asal, \r\n" + 
				"	t.kota_tujuan, t.voucher as banyak_voucher, t.pilih_tanggal as tanggal_berangkat, t.no_kursi,\r\n" + 
				"	tc.jenis_ticket, tc.deskripsi,\r\n" + 
				"	h.harga, h.diskon \r\n" + 
				"from \r\n" + 
				"	ticket_category tc \r\n" + 
				"	join ticket t on t.cat_id = tc.cat_id \r\n" + 
				"	join harga h on h.cat_id = tc.cat_id");
		return q.getResultList();
	}
}
