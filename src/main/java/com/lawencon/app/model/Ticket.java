package com.lawencon.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Ticket")
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTicket;
	private String namaPenumpang, kotaAsal, kotaTujuan;
	private int jumlahPenumpang, voucher;
	private String pilihTanggal, noKursi;
	
	@ManyToOne
	@JoinColumn(name = "catId", nullable = false)
	private TicketCategory catId;
	
	public TicketCategory getCatId() {
		return catId;
	}
	public void setCatId(TicketCategory catId) {
		this.catId = catId;
	}
	public int getIdTicket() {
		return idTicket;
	}
	public void setIdTicket(int idTicket) {
		this.idTicket = idTicket;
	}
	public String getNamaPenumpang() {
		return namaPenumpang;
	}
	public void setNamaPenumpang(String namaPenumpang) {
		this.namaPenumpang = namaPenumpang;
	}
	public String getKotaAsal() {
		return kotaAsal;
	}
	public void setKotaAsal(String kotaAsal) {
		this.kotaAsal = kotaAsal;
	}
	public String getKotaTujuan() {
		return kotaTujuan;
	}
	public void setKotaTujuan(String kotaTujuan) {
		this.kotaTujuan = kotaTujuan;
	}
	public int getJumlahPenumpang() {
		return jumlahPenumpang;
	}
	public void setJumlahPenumpang(int jumlahPenumpang) {
		this.jumlahPenumpang = jumlahPenumpang;
	}
	public int getVoucher() {
		return voucher;
	}
	public void setVoucher(int voucher) {
		this.voucher = voucher;
	}
	public String getPilihTanggal() {
		return pilihTanggal;
	}
	public void setPilihTanggal(String pilihTanggal) {
		this.pilihTanggal = pilihTanggal;
	}
	public String getNoKursi() {
		return noKursi;
	}
	public void setNoKursi(String noKursi) {
		this.noKursi = noKursi;
	}
}
