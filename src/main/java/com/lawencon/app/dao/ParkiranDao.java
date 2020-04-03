package com.lawencon.app.dao;

import java.util.List;

import com.lawencon.app.model.Parkiran;

public interface ParkiranDao {
	
	//Hibernate Version
	abstract String insertKendaraan(Parkiran kendaraan,String user,String pass) throws Exception;
	abstract Parkiran validKendaraanCheckIn(Parkiran kendaraan) throws Exception;
	abstract Parkiran validKendaraanCheckOut(Parkiran kendaraan) throws Exception;
	abstract String insertCheckoutKendaraan(Parkiran kendaraan,String user,String pass) throws Exception;
	abstract List<Parkiran> viewKendaraanCheckIn() throws Exception;
	abstract List<Parkiran> viewKendaraanCheckOut() throws Exception;
	
	//Jpa Version
	abstract Parkiran insert(Parkiran kendaraan) throws Exception;
	abstract Parkiran update(Parkiran kendaraan) throws Exception;
	
}
