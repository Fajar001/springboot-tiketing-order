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

import com.lawencon.app.model.Ticket;
import com.lawencon.app.service.TicketService;

@RestController
@RequestMapping("/tiket")
public class TicketController extends BaseController<Ticket>{
	
	@Autowired
	private TicketService ticketService;
	
	@GetMapping("/Home")
	public ResponseEntity<List<?>> getListCategory(@RequestHeader("Authorization") String user) {
		List<Ticket> listTicket = new ArrayList<>();
		try {
			String[] auth = super.authUser(user);
			listTicket = ticketService.findAll(auth[0], auth[1]);
		} catch (Exception e) {
			return new ResponseEntity<>(listTicket, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(listTicket, HttpStatus.OK);
	}
	
	@GetMapping("/Home/join")
	public ResponseEntity<List<?>> getJoin(@RequestHeader("Authorization") String user) {
		List<Ticket> listTicket = new ArrayList<>();
		try {
			String[] auth = super.authUser(user);
			listTicket = ticketService.joinAll(auth[0], auth[1]);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(listTicket, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(listTicket, HttpStatus.OK);
	}
	
	@GetMapping("/Home/trx")
	public ResponseEntity<List<?>> getTrx(@RequestHeader("Authorization") String user) {
		List<Ticket> listTicket = new ArrayList<>();
		try {
			String[] auth = super.authUser(user);
			listTicket = ticketService.trx(auth[0], auth[1]);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(listTicket, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(listTicket, HttpStatus.OK);
	}
	
	@PostMapping("/Home/insert")
	public ResponseEntity<?> getInsert(@RequestBody String content, @RequestHeader("Authorization") String user) {
		try {
			String[] auth = super.authUser(user);
			Ticket ticket = readValue(content, Ticket.class);
			ticketService.insert(ticket, auth[0], auth[1]);
			return new ResponseEntity<>("Berhasil Insert Data", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Gagal Insert Data", HttpStatus.BAD_REQUEST);
		}		
	}
	
	@PostMapping("/Home/update/{id}/{jumPenumpang}")
	public ResponseEntity<?> getUpdate(@PathVariable("id") int id, @PathVariable("jumPenumpang") int jumPenumpang, @RequestHeader("Authorization") String user) {
		try {
			String[] auth = super.authUser(user);
			ticketService.update(id, jumPenumpang, auth[0], auth[1]);
			return new ResponseEntity<>("Berhasil Update Data", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Gagal Update Data", HttpStatus.BAD_REQUEST);
		}		
	}
	
	@PostMapping("/Home/updatejpa/{id}/{jumPenumpang}")
	public ResponseEntity<?> getUpdatejpa(@PathVariable("id") int id, @PathVariable("jumPenumpang") int jumPenumpang, @RequestHeader("Authorization") String user) {
		try {
			String[] auth = super.authUser(user);;
			ticketService.updatejpa(id, jumPenumpang, auth[0], auth[1]);
			return new ResponseEntity<>("Berhasil Update Data", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Gagal Update Data", HttpStatus.BAD_REQUEST);
		}		
	}
	
	@PostMapping("/Home/delete/{id}")
	public ResponseEntity<?> getDelete(@PathVariable("id") int id, @RequestHeader("Authorization") String user) {
		try {
			String[] auth = super.authUser(user);
			ticketService.delete(id, auth[0], auth[1]);
			return new ResponseEntity<>("Berhasil Hapus Data", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Gagal Hapus Data", HttpStatus.BAD_REQUEST);
		}		
	}
}
