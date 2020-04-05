package com.lawencon.app.dao.impl.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lawencon.app.model.Ticket;

@Repository
public interface TicketDaoRepo extends JpaRepository<Ticket, Integer>{
	@Modifying
	@Query("update Ticket set jumlahPenumpang =:jumPenumpang where idTicket =:id")
	int update(@Param("id") int id, @Param("jumPenumpang") int jumPenumpang);
	
	@Query(value = "select t.nama_penumpang, t.jumlah_penumpang, t.kota_asal, "
			+ "t.kota_tujuan, t.voucher as banyak_voucher, t.pilih_tanggal as tanggal_berangkat, t.no_kursi, "
			+ "tc.jenis_ticket, tc.deskripsi, "
			+ "h.harga, h.diskon "
			+ "from ticket_category tc "
			+ "join ticket t on t.cat_id = tc.cat_id join harga h on h.cat_id = tc.cat_id", nativeQuery = true)
	List<Ticket> joinAll();
}
