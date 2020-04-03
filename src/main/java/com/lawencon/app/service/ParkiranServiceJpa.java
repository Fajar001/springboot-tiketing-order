package com.lawencon.app.service;

import java.util.List;

import com.lawencon.app.model.Parkiran;

public interface ParkiranServiceJpa {
	abstract String insert(Parkiran kendaraan, String user,String pass) throws Exception;
	abstract String update(Parkiran kendaraan, String user,String pass) throws Exception;
	abstract List<Parkiran> viewKendaraanCheckIn(String user,String pass) throws Exception;
	abstract List<Parkiran> viewKendaraanCheckOut(String user,String pass) throws Exception;
	abstract Boolean validKendaraanCheckIn(Parkiran kendaraan) throws Exception;
	abstract Boolean validKendaraanCheckOut(Parkiran kendaraan) throws Exception;
}
