package com.lawencon.app.dao.impl.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lawencon.app.model.Harga;

@Repository
public interface HargaRepo extends JpaRepository<Harga, Integer>{
	@Modifying
	@Query("update Harga set harga =:harga where idHarga =:id")
	int update(@Param("id") int id, @Param("harga") int harga);
}
