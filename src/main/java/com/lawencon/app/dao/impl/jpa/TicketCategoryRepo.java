package com.lawencon.app.dao.impl.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lawencon.app.model.TicketCategory;


@Repository
public interface TicketCategoryRepo extends JpaRepository<TicketCategory, Integer>{
	
	@Modifying
	@Query("update TicketCategory set jenisTicket =:jenis where catId =:id")
	int update(@Param("id") int id, @Param("jenis") String jenis);
}
