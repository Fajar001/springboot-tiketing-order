package com.lawencon.app.controller;
/*
 * 
 * @Author Fajar Setiawan
 * Valid : plat jenis apapun bisa masuk namun tidak bisa plat yang sama.
 * 
 */

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lawencon.app.model.Parkiran;
import com.lawencon.app.service.ParkiranService;
import com.lawencon.app.service.ParkiranServiceJpa;

@RestController
@RequestMapping("/kendaraan")
public class HomeController extends BaseController{
	
	@Autowired
	private ParkiranService pService;
	
	@Autowired
	private ParkiranServiceJpa jpaService;
	
	@Override
	String authUser(String user) throws Exception {
		byte[] decodeBytes = Base64.getDecoder().decode(user);
        String decodeString = new String(decodeBytes);
        return decodeString;
	}
	
	//HIBERNATE VERSION
	@PostMapping("/checkin")
	public ResponseEntity<?> insertHhiber(@RequestBody String content, @RequestHeader("Authorization") String user) {
		String pesan = "";
		boolean pesan1 = true;
		try {
			String[] auth = authUser(user).split(":");
			Parkiran kendaraan = new ObjectMapper().readValue(content, Parkiran.class);
			pesan = pService.insertKendaraan(kendaraan, auth[0], auth[1]);
			return new ResponseEntity<>(pesan, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(pesan1, HttpStatus.BAD_REQUEST);
		}		
	}

	@PostMapping("/checkout")
	public ResponseEntity<?> checkOut(@RequestBody String content, @RequestHeader("Authorization") String user) {
		String pesan = "" ;
		try {
			String[] auth = authUser(user).split(":");
			Parkiran kendaraan = new ObjectMapper().readValue(content, Parkiran.class);
			pesan = pService.insertCheckoutKendaraan(kendaraan,auth[0], auth[1]);
		} catch (Exception e) {
			return new ResponseEntity<>(pesan, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(pesan, HttpStatus.OK);
	}

	@GetMapping("/listcheckin")
	public ResponseEntity<List<Parkiran>> getListCheckIn(@RequestHeader("Authorization") String user) {
		List<Parkiran> listKendaraan = new ArrayList<>();
		try {
			String[] auth = authUser(user).split(":");
			listKendaraan = pService.viewKendaraanCheckIn(auth[0], auth[1]);
		} catch (Exception e) {
			return new ResponseEntity<>(listKendaraan, HttpStatus.OK);
		}
		return new ResponseEntity<>(listKendaraan, HttpStatus.OK);
	}

	@GetMapping("/listcheckout")
	public ResponseEntity<List<Parkiran>> getListCheckOut(@RequestHeader("Authorization") String user) {
		List<Parkiran> listKendaraan = new ArrayList<>();
		try {
			String[] auth = authUser(user).split(":");
			listKendaraan = pService.viewKendaraanCheckOut(auth[0], auth[1]);
		} catch (Exception e) {
			return new ResponseEntity<>(listKendaraan, HttpStatus.OK);
		}
		return new ResponseEntity<>(listKendaraan, HttpStatus.OK);
	}
	
//	//JPA VERSION
	@PostMapping("/checkinjpa")
	public ResponseEntity<?> getInsert(@RequestBody String content, @RequestHeader("Authorization") String user) {
		String pesan = null;
		try {
			String[] auth = authUser(user).split(":");
			Parkiran kendaraan = new ObjectMapper().readValue(content, Parkiran.class);
			pesan = jpaService.insert(kendaraan, auth[0], auth[1]);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(pesan, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(pesan, HttpStatus.OK);
	}
	
	@PostMapping("/checkoutjpa")
	public ResponseEntity<?> getUpdate(@RequestBody String content, @RequestHeader("Authorization") String user) {
		String pesan = null;
		try {
			String[] auth = authUser(user).split(":");
			Parkiran kendaraan = new ObjectMapper().readValue(content, Parkiran.class);
			pesan = jpaService.update(kendaraan, auth[0], auth[1]);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(pesan, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(pesan, HttpStatus.OK);
	}
	
	@GetMapping("/listcheckinjpa")
	public ResponseEntity<List<Parkiran>> getListCheckInJpa(@RequestHeader("Authorization") String user) {
		List<Parkiran> listKendaraan = new ArrayList<>();
		try {
			String[] auth = authUser(user).split(":");
			listKendaraan = jpaService.viewKendaraanCheckIn(auth[0], auth[1]);
		} catch (Exception e) {
			return new ResponseEntity<>(listKendaraan, HttpStatus.OK);
		}
		return new ResponseEntity<>(listKendaraan, HttpStatus.OK);
	}

	@GetMapping("/listcheckoutjpa")
	public ResponseEntity<List<Parkiran>> getListCheckOutJpa(@RequestHeader("Authorization") String user) {
		List<Parkiran> listKendaraan = new ArrayList<>();
		try {
			String[] auth = authUser(user).split(":");
			listKendaraan = jpaService.viewKendaraanCheckOut(auth[0], auth[1]);
		} catch (Exception e) {
			return new ResponseEntity<>(listKendaraan, HttpStatus.OK);
		}
		return new ResponseEntity<>(listKendaraan, HttpStatus.OK);
	}
}
