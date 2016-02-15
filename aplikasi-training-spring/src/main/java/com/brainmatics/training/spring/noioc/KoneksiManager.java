package com.brainmatics.training.spring.noioc;

public class KoneksiManager {
	private static KoneksiDatabase koneksi;
	
	public static KoneksiDatabase getKoneksi(){
		if(koneksi == null){
			koneksi = new KoneksiDatabase();
			koneksi.setHost("localhost");
			koneksi.setPort(3306);
			koneksi.setNamaDatabase("training");
			koneksi.setUsername("scott");
			koneksi.setPassword("tiger");
		}
		
		return koneksi;
	}
}
