package com.brainmatics.training.spring.ioc;

public class PesertaDao {
	
	private KoneksiDatabase koneksi;
	
	public void setKoneksi(KoneksiDatabase koneksi) {
		this.koneksi = koneksi;
	}

	public void simpan(){
		koneksi.connect();
		System.out.println("Menyimpan data");
		koneksi.disconnect();
	}
	
	public void hapus(){
		koneksi.connect();
		System.out.println("Menghapus data");
		koneksi.disconnect();
	}
		
}
