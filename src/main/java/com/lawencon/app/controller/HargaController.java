package com.lawencon.app.controller;
/*
 * 
 * @Author Fajar Setiawan
 * 
 */

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lawencon.app.model.Harga;
import com.lawencon.app.service.HargaService;

@RestController
@RequestMapping("/tiket")
public class HargaController extends BaseController<Harga>{
	
	@Autowired
	private HargaService hargaService;
	
	@GetMapping("/harga")
	public ResponseEntity<List<Harga>> getListCategory(@RequestHeader("Authorization") String user) {
		List<Harga> listCategory = new ArrayList<>();
		try {
			String[] auth = super.authUser(user);
			listCategory = hargaService.findAll(auth[0], auth[1]);
		} catch (Exception e) {
			return new ResponseEntity<>(listCategory, HttpStatus.OK);
		}
		return new ResponseEntity<>(listCategory, HttpStatus.OK);
	}
	
	@PostMapping("/harga/insert")
	public ResponseEntity<?> getInsert(@RequestBody String content, @RequestHeader("Authorization") String user) {
		try {
			String[] auth = super.authUser(user);
			Harga category = readValue(content, Harga.class);
			hargaService.insert(category, auth[0], auth[1]);
			return new ResponseEntity<>("Berhasil Insert Data", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Gagal Insert Data", HttpStatus.BAD_REQUEST);
		}		
	}
	
	@PostMapping("/harga/update/{id}/{harga}")
	public ResponseEntity<?> getUpdate(@PathVariable("id") int id, @PathVariable("harga") int harga, @RequestHeader("Authorization") String user) {
		try {
			String[] auth = super.authUser(user);
			hargaService.update(id, harga, auth[0], auth[1]);
			return new ResponseEntity<>("Berhasil Update Data", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Gagal Update Data", HttpStatus.BAD_REQUEST);
		}		
	}
	
	@PostMapping("/harga/updatejpa/{id}/{harga}")
	public ResponseEntity<?> getUpdatejpa(@PathVariable("id") int id, @PathVariable("harga") int harga, @RequestHeader("Authorization") String user) {
		try {
			String[] auth = super.authUser(user);
			hargaService.updatejpa(id, harga, auth[0], auth[1]);
			return new ResponseEntity<>("Berhasil Update Data", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Gagal Update Data", HttpStatus.BAD_REQUEST);
		}		
	}
	
	@PostMapping("/harga/delete/{id}")
	public ResponseEntity<?> getDelete(@PathVariable("id") int id, @RequestHeader("Authorization") String user) {
		try {
			String[] auth = super.authUser(user);
			hargaService.delete(id, auth[0], auth[1]);
			return new ResponseEntity<>("Berhasil Hapus Data", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Gagal Hapus Data", HttpStatus.BAD_REQUEST);
		}		
	}
}
