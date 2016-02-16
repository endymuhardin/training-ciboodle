package com.brainmatics.training.springboot.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity @Table(name="peserta")
public class Peserta {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotNull @NotEmpty @Size(min=3,max=10)
	@Column(unique=true, nullable=false)
	private String kode;
	
	@NotNull @NotEmpty @Size(min=2,max=255)
	@Column(nullable=false)
	private String nama;
	
	@NotNull @Past
	@Temporal(TemporalType.DATE)
	@Column(name="tanggal_lahir", nullable=false)
	private Date tanggalLahir;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getKode() {
		return kode;
	}

	public void setKode(String kode) {
		this.kode = kode;
	}

	public Date getTanggalLahir() {
		return tanggalLahir;
	}

	public void setTanggalLahir(Date tanggalLahir) {
		this.tanggalLahir = tanggalLahir;
	}
	
	
}
