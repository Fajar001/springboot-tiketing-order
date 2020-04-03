package com.lawencon.app.dao.impl.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lawencon.app.model.Parkiran;

@Repository
public interface ParkiranRepo extends JpaRepository<Parkiran, Integer>{
	@Query("from Parkiran where tanggalKeluar is null")
	List<Parkiran> listCheckIn();
	
	@Query("from Parkiran where tanggalKeluar is not null")
	List<Parkiran> listCheckOut();
}
