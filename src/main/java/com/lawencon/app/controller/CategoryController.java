package com.lawencon.app.controller;
/*
 * 
 * @Author Fajar Setiawan
 * 
 */

import java.util.ArrayList;
import java.util.Base64;
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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lawencon.app.model.TicketCategory;
import com.lawencon.app.service.TicketCategoryService;

@RestController
@RequestMapping("/tiket")
public class CategoryController extends BaseController{
	
	@Autowired
	private TicketCategoryService catService;
	
	@Override
	String authUser(String user) throws Exception {
		byte[] decodeBytes = Base64.getDecoder().decode(user);
        String decodeString = new String(decodeBytes);
        return decodeString;
	}
	
	@GetMapping("/category")
	public ResponseEntity<List<TicketCategory>> getListCategory(@RequestHeader("Authorization") String user) {
		List<TicketCategory> listKendaraan = new ArrayList<>();
		try {
			String[] auth = authUser(user).split(":");
			listKendaraan = catService.findAll(auth[0], auth[1]);
		} catch (Exception e) {
			return new ResponseEntity<>(listKendaraan, HttpStatus.OK);
		}
		return new ResponseEntity<>(listKendaraan, HttpStatus.OK);
	}
	
	@PostMapping("/category/insert")
	public ResponseEntity<?> getInsert(@RequestBody String content, @RequestHeader("Authorization") String user) {
		try {
			String[] auth = authUser(user).split(":");
			TicketCategory category = new ObjectMapper().readValue(content, TicketCategory.class);
			catService.insert(category, auth[0], auth[1]);
			return new ResponseEntity<>("Berhasil Insert Data", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Gagal Insert Data", HttpStatus.BAD_REQUEST);
		}		
	}
	
	@PostMapping("/category/update/{id}/{jenis}")
	public ResponseEntity<?> getUpdate(@PathVariable("id") int id, @PathVariable("jenis") String jenis, @RequestHeader("Authorization") String user) {
		try {
			String[] auth = authUser(user).split(":");
			catService.update(id, jenis, auth[0], auth[1]);
			return new ResponseEntity<>("Berhasil Update Data", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Gagal Update Data", HttpStatus.BAD_REQUEST);
		}		
	}
	
	@PostMapping("/category/updatejpa/{id}/{jenis}")
	public ResponseEntity<?> getUpdatejpa(@PathVariable("id") int id, @PathVariable("jenis") String jenis, @RequestHeader("Authorization") String user) {
		try {
			String[] auth = authUser(user).split(":");
			catService.updatejpa(id, jenis, auth[0], auth[1]);
			return new ResponseEntity<>("Berhasil Update Data", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Gagal Update Data", HttpStatus.BAD_REQUEST);
		}		
	}
	
	@PostMapping("/category/delete/{id}")
	public ResponseEntity<?> getDelete(@PathVariable("id") int id, @RequestHeader("Authorization") String user) {
		try {
			String[] auth = authUser(user).split(":");
			catService.delete(id, auth[0], auth[1]);
			return new ResponseEntity<>("Berhasil Hapus Data", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Gagal Hapus Data", HttpStatus.BAD_REQUEST);
		}		
	}
}
