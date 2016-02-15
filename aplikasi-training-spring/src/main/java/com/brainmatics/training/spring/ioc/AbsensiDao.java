package com.brainmatics.training.spring.ioc;

public class AbsensiDao {
	private KoneksiDatabase koneksi;
	
	public AbsensiDao(KoneksiDatabase k){
		this.koneksi = k;
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
