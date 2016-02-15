package com.brainmatics.training.spring.noioc;

public class AbsensiDao {
	private KoneksiDatabase koneksi;
	
	public AbsensiDao(){
		koneksi = new KoneksiDatabase();
		koneksi.setHost("localhost");
		koneksi.setPort(3306);
		koneksi.setNamaDatabase("training");
		koneksi.setUsername("scott");
		koneksi.setPassword("tiger");
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
