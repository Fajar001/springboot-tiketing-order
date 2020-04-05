package com.lawencon.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Harga")
public class Harga {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idHarga;
	private int harga, diskon;
	
	@ManyToOne
	@JoinColumn(name = "catId")
	private TicketCategory catId;

	public int getIdHarga() {
		return idHarga;
	}

	public void setIdHarga(int idHarga) {
		this.idHarga = idHarga;
	}

	public int getHarga() {
		return harga;
	}

	public void setHarga(int harga) {
		this.harga = harga;
	}

	public int getDiskon() {
		return diskon;
	}

	public void setDiskon(int diskon) {
		this.diskon = diskon;
	}

	public TicketCategory getCatId() {
		return catId;
	}

	public void setCatId(TicketCategory catId) {
		this.catId = catId;
	}
	
	
}
