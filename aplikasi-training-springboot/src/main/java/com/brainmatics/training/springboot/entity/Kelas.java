package com.brainmatics.training.springboot.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity @Table(name="kelas")
public class Kelas {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(unique=true, nullable=false)
	private String kode;
	
	@Column(nullable=false)
	private String nama;
	
	@Temporal(TemporalType.DATE)
	@Column(name="tanggal_mulai", nullable=false)
	private Date tanggalMulai;

	@Temporal(TemporalType.DATE)
	@Column(name="tanggal_selesai", nullable=false)
	private Date tanggalSelesai;
	
	@ManyToOne
	@JoinColumn(name="id_instruktur", nullable=false)
	private Instruktur instruktur;
	
	@ManyToMany
	@JoinTable(
		name="peserta_training",
		joinColumns=@JoinColumn(name="id_kelas"), 
		inverseJoinColumns=@JoinColumn(name="id_peserta")
	)
	private List<Peserta> daftarPeserta = new ArrayList<Peserta>();

	
	@OneToMany(mappedBy="kelas", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<DetailMateriKelas> daftarMateri = new ArrayList<DetailMateriKelas>();
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKode() {
		return kode;
	}

	public void setKode(String kode) {
		this.kode = kode;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public Date getTanggalMulai() {
		return tanggalMulai;
	}

	public void setTanggalMulai(Date tanggalMulai) {
		this.tanggalMulai = tanggalMulai;
	}

	public Date getTanggalSelesai() {
		return tanggalSelesai;
	}

	public void setTanggalSelesai(Date tanggalSelesai) {
		this.tanggalSelesai = tanggalSelesai;
	}

	public Instruktur getInstruktur() {
		return instruktur;
	}

	public void setInstruktur(Instruktur instruktur) {
		this.instruktur = instruktur;
	}

	public List<Peserta> getDaftarPeserta() {
		return daftarPeserta;
	}

	public void setDaftarPeserta(List<Peserta> daftarPeserta) {
		this.daftarPeserta = daftarPeserta;
	}

	public List<DetailMateriKelas> getDaftarMateri() {
		return daftarMateri;
	}

	public void setDaftarMateri(List<DetailMateriKelas> daftarMateri) {
		this.daftarMateri = daftarMateri;
	}
}
